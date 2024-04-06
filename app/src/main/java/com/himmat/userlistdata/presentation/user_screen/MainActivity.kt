package com.himmat.userlistdata.presentation.user_screen

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toolbar
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.himmat.userlistdata.R
import com.himmat.userlistdata.common.delegations.CheckNetwork
import com.himmat.userlistdata.common.delegations.CheckNetworkImpl
import com.himmat.userlistdata.presentation.user_screen.adapter.UserListAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), CheckNetwork by CheckNetworkImpl() {

    private val TAG = "MainActivity"

    private val userViewModel: UserViewModel by viewModels()

    private lateinit var userListAdapter: UserListAdapter
    private var recyclerViewUser: RecyclerView? = null
    private var progressBar: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.statusBarColor = resources.getColor(R.color.dark_indigo)

        progressBar = findViewById(R.id.progressBar!!)



        userListAdapter = UserListAdapter(this)
        initRecyclerView()


        if (isOnline(this)){
            userViewModel.getUserListData()
                .observe(this){flow ->

                    lifecycleScope.launch {
                        flow.collectLatest {
                            userListAdapter.submitData(it)

                        }
                    }
                }
        }else{

            userViewModel.fetchUserFromDB()
            userViewModel.getUserListData()
                .observe(this){flow ->

                    lifecycleScope.launch {
                        flow.collectLatest {

                            userListAdapter.submitData(it)

                        }
                    }
                }
        }

    }

    private fun initRecyclerView(){
        recyclerViewUser = findViewById(R.id.rvUserList)
        recyclerViewUser?.layoutManager = LinearLayoutManager(this)
        recyclerViewUser?.adapter =  userListAdapter
    }

    private fun showProgressIndicator(show: Boolean){

      if (show){
          progressBar?.visibility = View.VISIBLE
      }else{
          progressBar?.visibility = View.GONE
      }
    }
}