package com.definelab.firstkotlinprogram

fun main(args: Array<String>) {
    print("Enter the number of day : ")
    var daynum:Int = readLine()!!.toInt()

    when(daynum){
        1 -> println("Day is Monday")
        2 -> println("Day is Tuesday")
        3 -> println("Day is Wednesday")
        4 -> println("Day is Thursday")
        5 -> println("Day is Friday")
        6 -> println("Day is Saturday")
        7 -> println("Day is Sunday")
        else -> println("Invalid day")
    }


}