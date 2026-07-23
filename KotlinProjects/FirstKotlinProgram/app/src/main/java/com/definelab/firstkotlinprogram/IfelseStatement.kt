package com.definelab.firstkotlinprogram

fun main(args: Array<String>) {
    print("Enter a number : ")
    var num : Int = readLine()!!.toInt()

    if(num%2==0){
        println("$num is a even number")
    }else{
        println("$num is a odd number")
    }
}
