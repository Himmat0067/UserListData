package com.himmat.userlistdata

import androidx.room.Room
import com.himmat.userlistdata.data.local.dao.UserDao
import com.himmat.userlistdata.data.local.database.UserDatabase
import org.junit.After
import org.junit.Before

class UserDaoTest {

    lateinit var userDatabase: UserDatabase
    lateinit var userDao: UserDao

    @Before
    fun setUp(){
    }


    @After
    fun tearDown(){

    }
}