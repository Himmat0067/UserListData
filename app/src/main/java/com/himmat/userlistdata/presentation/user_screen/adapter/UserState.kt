package com.himmat.userlistdata.presentation.user_screen.adapter

import android.provider.ContactsContract.Data

data class UserState(
    val isLoading: Boolean = false,
    var error: String? = null,
    val data: List<Data>? = null
)
