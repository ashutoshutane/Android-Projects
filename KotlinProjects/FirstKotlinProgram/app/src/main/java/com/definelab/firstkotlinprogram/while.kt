package com.definelab.firstkotlinprogram

import kotlin.random.Random

fun main(args: Array<String>) {
    /*
    var i = 5
    while (i>0){
        println("i = $i")
        i--
    }
     */

    /*
    var k =1;
    var fact = 1;

    while (k<6){
        fact *= k
        println("$k! = $fact")
        k++
    }
    */

    //infinite loop

    var number = Random.nextInt(0,100)

    while(true){
        println("please enter a number : ")
        val guess = readLine()!!.toInt()

        if(guess == number){
            println("You won")
            break
        }else if(guess<number){
            println("Too low")
        }else{
            println("Too high")

        }
    }


}