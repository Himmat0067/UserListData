package com.himmat.userlistdata.domain.models

import java.io.Serializable

data class UserResponse(
    val data: List<Data>,
    val page: Int,
    val per_page: Int,
    val support: Support,
    val total: Int,
    val total_pages: Int
): Serializable