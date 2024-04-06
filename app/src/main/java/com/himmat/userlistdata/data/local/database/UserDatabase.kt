package com.himmat.userlistdata.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.himmat.userlistdata.data.local.dao.UserDao
import com.himmat.userlistdata.domain.models.Data

@Database(entities = [Data::class], version = 1, exportSchema = false)
abstract class UserDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
}