package com.definelab.cofeeappusingcompose.model

import com.google.android.gms.common.api.Status
import java.util.Date

data class Orders(
    val oid:String,
    val uid:String,
    val amount: Double,
    val date: Long,
    val status: String,
    val paymentMethod:String,
    val items: List<OrderItems>
) {

}