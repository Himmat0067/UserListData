package com.himmat.userlistdata.domain.repository

import com.himmat.userlistdata.domain.models.UserResponse

interface GetUsersRepository {
    suspend fun getUserList(page: Int): UserResponse
}