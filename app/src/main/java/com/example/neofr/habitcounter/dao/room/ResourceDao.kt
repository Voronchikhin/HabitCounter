package com.example.neofr.habitcounter.dao.room

import android.arch.persistence.room.*
import com.example.neofr.habitcounter.model.dto.Resource

@Dao
interface ResourceDao {
    @Query("SELECT * FROM RESOURCE")
    fun getAll(): List<Resource>

    @Query("SELECT * FROM RESOURCE WHERE name= :name")
    fun getByName(name: String): Resource?

    @Query("SELECT * FROM RESOURCE WHERE id= :id")
    fun getById(id: Long): Resource?

    @Insert
    fun insert(vararg RESOURCE: Resource)

    @Update
    fun update(vararg RESOURCE: Resource)

    @Delete
    fun delete(vararg RESOURCE: Resource)
}