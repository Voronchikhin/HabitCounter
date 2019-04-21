package com.example.neofr.RESOURCEcounter.dao.room

import android.arch.persistence.room.*
import com.example.neofr.habitcounter.model.Resource

@Dao
interface ResourceDao {
    @Query("SELECT * FROM RESOURCE")
    fun getAll(): List<Resource>

    @Query("SELECT * FROM RESOURCE WHERE name= :name")
    fun getByName(name: String): Resource

    @Query("SELECT * FROM RESOURCE WHERE id= :id")
    fun getById(id: Long): Resource

    @Insert
    fun insert(RESOURCE: Resource)

    @Update
    fun update(RESOURCE: Resource)

    @Delete
    fun delete(RESOURCE: Resource)
}