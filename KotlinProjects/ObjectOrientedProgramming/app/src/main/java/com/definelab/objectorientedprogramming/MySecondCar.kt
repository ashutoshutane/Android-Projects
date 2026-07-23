package com.definelab.objectorientedprogramming

class MySecondCar {
    var name:String? = null
        set
        get
    var model:Int? = null
        get

    constructor(name: String?, model: Int?) {
        this.name = name
        this.model = model
    }
}