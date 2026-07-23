package com.definelab.objectorientedprogramming.override

fun main(args: Array<String>) {
    var vehicle : Vehicle = Vehicle()

    vehicle.start()
    vehicle.accelerate(80)
    vehicle.stop()

    println("-------------------------------------------------------------")

    var car = Car()

    car.superStar()
    car.superAccelerate()
    car.superStop()

    println("-------------------------------------------------------------")

    car.start()
    car.accelerate(100)
    car.stop()

}