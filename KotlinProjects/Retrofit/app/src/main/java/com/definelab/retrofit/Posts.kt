package com.definelab.retrofit

import com.google.gson.annotations.SerializedName

data class Posts(
    val userId: Int,
    val id: Int,
    val title: String,
    @SerializedName("body")
    //if the variable name and restapi value name is same then there is no need to use this annotation we use this when the variable name and the restapi value name is different

    val subtitle: String
) {
}