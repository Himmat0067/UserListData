package com.himmat.userlistdata.domain.use_cases.get_users

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.himmat.userlistdata.data.local.database.UserDatabase
import com.himmat.userlistdata.domain.models.Data
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UsersDataResource @Inject constructor(
    private val getUserListUseCase: GetUserListUseCase,
    private val userDatabase: UserDatabase
): PagingSource<Int,Data>() {

    private val TAG = "UsersDataResource"

    override fun getRefreshKey(state: PagingState<Int, Data>): Int? {

        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }

      /*  if (state.anchorPosition != null){
            val anchorPage = state.closestPageToPosition(state.anchorPosition!!)

            if (anchorPage?.prevKey != null){
                return anchorPage?.prevKey?.plus(1)
            }else if (anchorPage?.nextKey != null){
                return anchorPage?.nextKey?.minus(1)
            }else{
                return null
            }
        }*/
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Data> {

        try {
            val currentLoadingPageKey = params.key ?: 1

            Log.d(TAG,"The Page Count is $currentLoadingPageKey")
            val response = getUserListUseCase.getUserList(currentLoadingPageKey)

            val users = mutableListOf<Data>()
            val data = response.data
            users.addAll(data)

            withContext(Dispatchers.IO){

                if (currentLoadingPageKey == 1){
                    userDatabase.userDao().deleteAll()
                }
                userDatabase.userDao().insert(data)
            }

            Log.d(TAG, "User List: ${data}")


            return LoadResult.Page(
                data = users,
                prevKey = if (currentLoadingPageKey == 1) null else currentLoadingPageKey - 1,
                nextKey = if (currentLoadingPageKey == response.total_pages) null else currentLoadingPageKey+1
            )
        }catch (e: Exception){
            Log.d(TAG,"Fails -<> ${e.printStackTrace().toString()}")
            return LoadResult.Error(e)
        }

    }

}