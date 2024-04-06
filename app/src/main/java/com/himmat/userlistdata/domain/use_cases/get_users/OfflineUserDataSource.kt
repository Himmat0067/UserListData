package com.himmat.userlistdata.domain.use_cases.get_users

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.himmat.userlistdata.data.local.database.UserDatabase
import com.himmat.userlistdata.domain.models.Data
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class OfflineUserDataSource @Inject constructor(
    private val userDatabase: UserDatabase
):PagingSource<Int,Data>() {

    private val TAG = "OfflineUserDataSource"

    override fun getRefreshKey(state: PagingState<Int, Data>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Data> {
        try {
            val currentLoadingPageKey = params.key ?: 1

            Log.d(TAG,"The Page Count is $currentLoadingPageKey")
            var response: List<Data> ?= null
            var count  = 0
            var total_page = 0

            withContext(Dispatchers.IO){
                count = userDatabase.userDao().getCount()
                total_page = count/6
               response = userDatabase.userDao().getAllUsers()
            }

            Log.d(TAG, "load: Count =  ${count}")
            Log.d(TAG, "load: total pages =  ${total_page}")

            val users = mutableListOf<Data>()
            val data = response
            if (data != null) {
                users.addAll(data)
            }

            Log.d(TAG, "User List: ${data}")


            return LoadResult.Page(
                data = users,
                prevKey = if (currentLoadingPageKey == 1) null else currentLoadingPageKey - 1,
                nextKey = if (currentLoadingPageKey == total_page) null else currentLoadingPageKey+1
            )
        }catch (e: Exception){
            Log.d(TAG,"Fails -<> ${e.printStackTrace().toString()}")
            return LoadResult.Error(e)
        }

    }
}