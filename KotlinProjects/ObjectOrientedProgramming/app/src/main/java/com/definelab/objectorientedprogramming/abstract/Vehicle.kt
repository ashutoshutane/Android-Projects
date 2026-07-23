package com.definelab.objectorientedprogramming.abstract

abstract class Vehicle {
    //abstract function
    abstract fun vehicle(name:String):String

    //non-abstract function
    fun vehicleType(type:String):String{
        return type
    }

    //abstract property
    abstract var model:Int

    //non-abstract
    var speed:Int? = null
}