package com.definelab.firstkotlinprogram

fun main(args: Array<String>) {

    print("Please enter 3 numbers : ")
    var num1:Int = readLine()!!.toInt()
    var num2:Int = readLine()!!.toInt()
    var num3:Int = readLine()!!.toInt()

    var largestNumber : Int

    if(num1>=num2 && num1>=num3){
        largestNumber = num1
    }else if(num2>=num1 && num2>=num3){
        largestNumber = num2
    }else{
        largestNumber = num3
    }
    println("Largest number is $largestNumber")



//print("Enter age : ")

 /*   var age:Int = readLine()!!.toInt()
    if(age<13){
        println("You are a kid")
    }else if(age<19){
        println("You are a teenager")
    }else{
        if(age<65) {
            println("You are an adult")
        }
        else{
            println("You are senior citizen")
        }
    }

  */


}