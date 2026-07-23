package com.definelab.objectorientedprogramming.override

open class Vehicle {
    open fun start(){
        println("Vehicle has started")
    }

    open fun accelerate(speed:Int){
        println("vehicle accelerated at speed $speed")
    }

    open fun stop(){
        println("Vehicle has stopped")
    }
}