package com.definelab.objectorientedprogramming

fun main(args: Array<String>) {

    //Creating an object from a class
    /*var myCar:Cars = Cars()
    myCar.name = "Toyota"
    myCar.model = 2020

    var myCar2:Cars = Cars()
    myCar2.name = "BMW"
    myCar2.model = 2022


    println("My car name is ${myCar.name} and my car model is ${myCar.model}")
    println("My car name is ${myCar2.name} and my car model is ${myCar2.model}")
     */

//    var myNewCar = MyCars(name = "Toyota",model = 2020)
//    println("My car name is ${myNewCar.name} and my car model is ${myNewCar.model}")

    var mySecondCar = MySecondCar("Toyota",2020)

    mySecondCar.name = "BMW"
    mySecondCar.model = 2022 //set

    println("My second car name is ${mySecondCar.name} and my second car model is ${mySecondCar.model}")//get

}