package com.himmat.userlistdata.data.repository

import com.himmat.userlistdata.data.remote.WebApiService
import com.himmat.userlistdata.domain.models.UserResponse
import com.himmat.userlistdata.domain.repository.GetUsersRepository
import javax.inject.Inject

class GetUsersRepositoryImpl @Inject constructor(
    private val webApiService: WebApiService
): GetUsersRepository {
    override suspend fun getUserList(page: Int): UserResponse {
        return webApiService.getUserList(page)
    }
}