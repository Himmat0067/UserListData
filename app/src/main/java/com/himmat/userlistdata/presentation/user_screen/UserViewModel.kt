package com.himmat.userlistdata.presentation.user_screen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.himmat.userlistdata.data.local.database.UserDatabase
import com.himmat.userlistdata.domain.models.Data
import com.himmat.userlistdata.domain.use_cases.get_users.GetUserListUseCase
import com.himmat.userlistdata.domain.use_cases.get_users.OfflineUserDataSource
import com.himmat.userlistdata.domain.use_cases.get_users.UsersDataResource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUserListUseCase: GetUserListUseCase,
    private val userDatabase: UserDatabase
): ViewModel() {

    private val getUserData = MutableLiveData<Flow<PagingData<Data>>>()


    init {

        makeUserApiCall()
    }


    fun getUserListData(): MutableLiveData<Flow<PagingData<Data>>> = getUserData


    fun makeUserApiCall(){

        getUserData.value = Pager(PagingConfig(
            pageSize = 6,
            maxSize = 30,
        )){
            UsersDataResource(
                getUserListUseCase = getUserListUseCase,
                userDatabase = userDatabase,

            )
        }.flow.cachedIn(viewModelScope)
    }


    fun fetchUserFromDB(){
        
        getUserData.value = Pager(PagingConfig(
            pageSize = 6,
        )){
            OfflineUserDataSource(
                userDatabase = userDatabase,

                )
        }.flow.cachedIn(viewModelScope)
    }
}