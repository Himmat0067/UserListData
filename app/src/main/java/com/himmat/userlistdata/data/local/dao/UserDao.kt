package com.himmat.userlistdata.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.himmat.userlistdata.domain.models.Data

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(users: List<Data>)

    @Query("DELETE FROM Data")
    fun deleteAll()

    @Query("SELECT * FROM Data")
    fun getAllUsers(): List<Data>

    @Query("SELECT COUNT(*) FROM Data")
    fun getCount(): Int

}