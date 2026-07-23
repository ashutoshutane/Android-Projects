package com.definelab.firstkotlinprogram

fun main(args: Array<String>) {
    var myCharRange = 'a' .rangeTo('j')

    var numRange =  1 .rangeTo(10)

    var myChar = 'k' in myCharRange

    println(myChar)
}