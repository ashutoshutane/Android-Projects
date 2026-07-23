package com.definelab.assingment.data.model

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("response")
    val response: InnerResponse) {
}

data class InnerResponse(
    @SerializedName("venues")
    val venue: List<Venue>) {
}