package com.himmat.userlistdata.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Data(
    @PrimaryKey
    val id: Int,

    val avatar: String,

    val email: String,

    val first_name: String,

    val last_name: String
): Serializable