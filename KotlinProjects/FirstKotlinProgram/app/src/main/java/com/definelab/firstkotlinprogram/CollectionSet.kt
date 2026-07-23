package com.definelab.firstkotlinprogram

fun main(args: Array<String>) {
 /*   var mySetArray = arrayListOf<Any>("Kotlin", 2, 2.5, 'k',true,"Kotlin")

    println(mySetArray.size)
    println(mySetArray.last())

  */

    var mySet = setOf<Any>("Kotlin", 2, 2.5, 'k',true,"Kotlin")
    println(mySet.size)
    println(mySet.last())
}