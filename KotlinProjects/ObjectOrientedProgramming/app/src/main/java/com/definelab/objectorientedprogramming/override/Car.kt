package com.definelab.objectorientedprogramming.override

class Car : Vehicle() {

    fun superStar(){
        super.start()
    }

    fun superAccelerate(){
        super.accelerate(40)
    }

    fun superStop(){
        super.stop()
    }
    override fun start(){
        println("Car has started")
    }

    override fun accelerate(speed:Int){
        println("Car accelerated at speed $speed")
    }

    override fun stop(){
        println("Car has stopped")
    }

}