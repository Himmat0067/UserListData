package com.himmat.userlistdata.data.remote

import com.himmat.userlistdata.common.EndPoints
import com.himmat.userlistdata.domain.models.UserResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WebApiService {
    @GET(EndPoints.USERS)
    suspend fun getUserList(@Query("page") page: Int): UserResponse
}