package com.himmat.userlistdata.domain.use_cases.get_users

import com.himmat.userlistdata.domain.repository.GetUsersRepository
import javax.inject.Inject

class GetUserListUseCase @Inject constructor(
    private val getUsersRepository: GetUsersRepository
) {

    suspend fun getUserList(page: Int) = getUsersRepository.getUserList(page)
}