package com.definelab.firstkotlinprogram


fun main(args: Array<String>) {
    var age  = arrayOf(1,2,3);
    println("First element of Array is "+age.get(0));
//    println("First element of Array is "+age[0]);
    println("Second element of Array is "+age.get(1));
//    println("Second element of Array is "+age[1]);
    println("Third element of Array is "+age.get(2));
//    println("Third element of Array is "+age[2]);
println("************************************************************")
    var cars = arrayOf("Volvo", "BMW", "Ford", "Mazda")
    println("First element of Array is "+cars.get(0));
//    println("First element of Array is "+cars[0]);
    println("Second element of Array is "+cars.get(1));
//    println("Second element of Array is "+cars[1]);
    println("Third element of Array is "+cars.get(2));
//    println("Third element of Array is "+cars[2]);
    println("Fourth element of Array is "+cars.get(3));
//    println("Fourth element of Array is "+cars[3]);)

    cars.set(0,"Audi");
    println("First element of Array is "+cars.get(0));
//    println("First element of Array is "+cars[0]);

    println("Size of cars arrays : "+cars.size)
println("*************************************************************")

    var carsAndAge = arrayOf("Volvo",2,"BMW",3,"Ford",4,"Mazda",5)
    println("First element of Array is "+carsAndAge.get(0));
    println("Second element of Array is "+carsAndAge.get(1));
    println("Third element of Array is "+carsAndAge.get(2));
    println("Fourth element of Array is "+carsAndAge.get(3));
    println("Fifth element of Array is "+carsAndAge.get(4));
    println("Sixth element of Array is "+carsAndAge.get(5));
    println("Seventh element of Array is "+carsAndAge.get(6));
    println("Eighth element of Array is "+carsAndAge.get(7));


}