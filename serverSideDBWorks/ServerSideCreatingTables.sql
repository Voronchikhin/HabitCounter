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

