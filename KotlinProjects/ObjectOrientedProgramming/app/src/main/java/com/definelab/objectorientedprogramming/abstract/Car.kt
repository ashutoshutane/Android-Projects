package com.definelab.objectorientedprogramming.abstract

class Car(override var model: Int) : Vehicle() {
    override fun vehicle(name: String): String {
        return name
    }
}