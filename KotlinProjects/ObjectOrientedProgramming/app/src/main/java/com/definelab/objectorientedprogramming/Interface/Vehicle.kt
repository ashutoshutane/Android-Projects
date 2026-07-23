package com.definelab.objectorientedprogramming.Interface

class Vehicle : CanGo, CanStop{
    override val name: String
        get() = "Ferrari"

    override fun stop() {
       println("Vehicle stopped")
    }

}