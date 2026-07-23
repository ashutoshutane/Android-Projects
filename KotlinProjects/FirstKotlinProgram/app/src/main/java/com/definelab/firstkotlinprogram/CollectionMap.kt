package com.definelab.firstkotlinprogram

fun main(args: Array<String>) {

    //Immutable Collection
    println("-------------------immutable map of----------------------")
    var age = mapOf<String, Int>("david" to 20 ,"ronaldo" to 25)

    println("age of david is "+age["david"])
    println("age of ronaldo is "+age["ronaldo"])
    //mutable
    var mutableAge = mutableMapOf<String, Int>("david" to 20 ,"ronaldo" to 25)

    mutableAge.put("messi",35)

    println("-------------------mutable map of----------------------")
    println("age of david is "+age["david"])
    println("age of ronaldo is "+age["ronaldo"])
    println("age of messi is "+mutableAge["messi"])
}