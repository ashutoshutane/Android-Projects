package com.definelab.firstkotlinprogram

fun main(args: Array<String>) {
    print("Enter num 1 : ")
    var num1 = readLine()!!.toInt()
    print("Enter num 2 : ")
    var num2 = readLine()!!.toInt()
    print("Enter num 1 : ")
    var num3 = readLine()!!.toInt()

    var min : Int = findMinimumNumber(97,65,50)

    println(min)

//    var result = 0
//
//    result = add(num1,num2)
//
//    println("Sum of $num1 and $num2 is $result")
}

fun add(x:Int,y:Int):Int{
    var sum:Int = 0;
    sum = x + y
    return sum
}

fun findMinimumNumber(num1:Int,num2:Int,num3:Int):Int{
    if(num1>num2 && num1>num3){
        return num1
    }else if(num2>num1 && num2>num3){
        return num2
    }else if(num3>num1 && num3>num2){
        return num3
    }else{
        return 0
    }
}
