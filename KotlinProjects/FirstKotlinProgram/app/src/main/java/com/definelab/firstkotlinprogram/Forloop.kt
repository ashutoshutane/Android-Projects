package com.definelab.firstkotlinprogram

fun main(args: Array<String>) {
/*
    for (i in 1..10 ){
        println("i = $i")
    }

 */
/*
    var sum:Int = 0;
    for(i in 0..5){
        sum+=i
    }
    println(sum)
 */
/*
    var sum:Int = 0;
    for(i in 0..10){
        if(i%2==0){
            println("$i")
            sum += i
        }
    }
    println("Sum of even numbers = $sum")

 */
    /*
    var myArray = arrayListOf<Int>(1,2,3,4,5,6,7,8,9,10)

    for(i in myArray){
        println("i = $i")
    }
     */
/*
    var myArray = arrayListOf<Int>(1,2,3,4,5,6,7,8,9,10)

    for(i in 0..(myArray.size)-1){
        println("myArray[$i] = ${myArray[i]}")
    }
 */
/*
    var myArray = arrayListOf<Int>(1,2,3,4,5,5,6,7,8,9,10)

    for(i in myArray.indices){
        println("myArray[$i] = ${myArray[i]}")
    }
 */

    //For Each
    var myArray = arrayListOf<Int>(1,2,3,4,5,5,6,7,8,9,10)

    myArray.forEach { println(it) }
}