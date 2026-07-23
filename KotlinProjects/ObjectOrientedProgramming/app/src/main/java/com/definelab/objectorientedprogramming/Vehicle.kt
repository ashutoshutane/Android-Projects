package com.definelab.objectorientedprogramming

open class Vehicle {
    var type:String? = null
    var model:String?  = null
    var maxSpeed:Int? = null

    fun show(){
        println("Type of vehicle is $type")
        println("Model of vehicle is $model")
        println("Max speed of vehicle is $maxSpeed")
    }


}
