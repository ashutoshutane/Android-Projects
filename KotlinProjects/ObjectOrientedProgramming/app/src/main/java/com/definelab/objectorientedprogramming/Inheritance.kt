package com.definelab.objectorientedprogramming

fun main(args: Array<String>) {


    //creating an object from car class
    var car1 : Car = Car()
    car1.type = "car"
    car1.model = "Ferrari"
    car1.maxSpeed = 350

    car1.show()

    println("------------------------------------------------------------------")

    //creating an object from motorcycle class
    var motorcycle1 : Motorcycle = Motorcycle()
    motorcycle1.type = "motorcycle"
    motorcycle1.model = "Harley Davidson"
    motorcycle1.maxSpeed = 250

    motorcycle1.show()

}