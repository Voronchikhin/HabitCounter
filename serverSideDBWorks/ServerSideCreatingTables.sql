CREATE TABLE AppUser (
    user_id INT IDENTITY(1,1) PRIMARY KEY,
    user_name NVARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE Habit (
  habit_id INT IDENTITY(1,1) PRIMARY KEY ,
  habit_name NVARCHAR(50) UNIQUE NOT NULL ,   --no same names for habits
  habit_description NVARCHAR(200)
);

CREATE TABLE User_Habit (
  user_id INT,
  habit_id INT,
  FOREIGN KEY (user_id) REFERENCES AppUser(user_id),
  FOREIGN KEY (habit_id) REFERENCES Habit(habit_id)
)

CREATE TABLE Measure (
  measure_id INT IDENTITY(1,1) PRIMARY KEY ,
  measure_name NVARCHAR(50) UNIQUE NOT NULL ,
);

CREATE TABLE Resource (
  resource_id INT IDENTITY(1,1) PRIMARY KEY ,
  resource_name NVARCHAR(50) UNIQUE NOT NULL ,
  resource_description NVARCHAR(200),
  measure_id INT,
  total_count FLOAT,
  FOREIGN KEY (measure_id) REFERENCES Measure(measure_id)
);

CREATE TABLE Habit_Resource (
  habit_id INT,
  resource_id INT,
  resource_per_time FLOAT,
  FOREIGN KEY (habit_id) REFERENCES Habit(habit_id),
  FOREIGN KEY (resource_id) REFERENCES Resource(resource_id)
)

CREATE TABLE ServerLog (
  log_record_id INT IDENTITY(1,1) PRIMARY KEY,
  user_id INT,
  habit_id INT,
  month_start DATE,
  counter INT,
  FOREIGN KEY (user_id) REFERENCES AppUser(user_id),
  FOREIGN KEY (habit_id) REFERENCES Habit(habit_id)
)

CREATE TABLE MonthServerLog (
  log_record_id INT IDENTITY(1,1) PRIMARY KEY,
  habit_id INT,
  user_id INT,
  actionDate DATE
    -- other fields
  FOREIGN KEY (user_id) REFERENCES AppUser(user_id),
  FOREIGN KEY (habit_id) REFERENCES Habit(habit_id)
)

CREATE OR ALTER TRIGGER new_habit_check ON Habit
  INSTEAD OF INSERT, UPDATE
AS
  BEGIN
    IF exists(SELECT * from Habit where Habit.habit_name = (select habit_name from inserted))
      update Habit set habit_description = Habit.habit_description + ' ' +
                                           ( select habit_description from inserted)
      where Habit.habit_name = (select habit_name from inserted);
    ELSE
      INSERT INTO Habit (habit_name, habit_description)
        select habit_name, habit_description from inserted;
  END;

CREATE OR ALTER PROCEDURE addLogRecord(@habit_id INT, @user_id INT, @actionDate DATE)
AS
  BEGIN
    SET NOCOUNT ON;
    INSERT INTO MonthServerLog VALUES (@habit_id, @user_id, @actionDate);
  END;
GO;



CREATE OR ALTER PROCEDURE clearMonthServerLog
AS
  BEGIN
    SET NOCOUNT ON;
    TRUNCATE TABLE MonthServerLog;
    --if trigger on delete added:
    --DELETE MonthServerLog;
  END;
GO;

CREATE OR ALTER PROC countOfActions (@habit_id INT, @user_id INT)
AS
  BEGIN
    DECLARE @count INT;
    SELECT @count = count(log_record_id) FROM MonthServerLog WHERE
      user_id = @user_id AND habit_id = @habit_id
    SET @count = ISNULL(@count, 0);
    RETURN @count;
  END;
GO;

CREATE OR ALTER PROCEDURE updateStatistics
AS
  BEGIN
    DECLARE @CURSOR CURSOR
    DECLARE @habit_id INT
    DECLARE @user_id INT
    SET @CURSOR  = CURSOR SCROLL
    FOR
    SELECT habit_id, user_id FROM MonthServerLog;
    OPEN @CURSOR
    FETCH NEXT FROM @CURSOR INTO @habit_id, @user_id;
    WHILE @@FETCH_STATUS = 0
      BEGIN
        IF EXISTS(SELECT * FROM ServerLog WHERE habit_id=@habit_id AND user_id=@user_id)
          BEGIN
            UPDATE ServerLog SET ServerLog.counter = ServerLog.counter + 1
            WHERE habit_id=@habit_id AND user_id=@user_id
          END
        ELSE
          INSERT INTO ServerLog VALUES (@user_id, @habit_id, GETDATE(), 1);
        FETCH NEXT FROM @CURSOR INTO @habit_id, @user_id;
      END
    CLOSE @CURSOR
    EXECUTE clearMonthServerLog;
  END
  GO;

