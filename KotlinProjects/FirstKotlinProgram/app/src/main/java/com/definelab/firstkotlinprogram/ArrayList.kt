package com.definelab.firstkotlinprogram

fun main(args: Array<String>) {
    var age = arrayListOf<Int>();

    age.add(10)
    age.add(1,20)
    age.add(0,30)
    age.add(40)

    println("First element of ArrayList is "+age.get(0));
    println("Second element of ArrayList is "+age.get(1));
    println("Third element of ArrayList is "+age.get(2));
    println("Fourth element of ArrayList is "+age.get(3));
    println("Size of ArrayList : "+age.size )
    println("***************************************************");
    age.remove(20);
    age.removeAt(0);

    println("First element of ArrayList is "+age.get(0));
    println("Second element of ArrayList is "+age.get(1));
    println("Size of ArrayList : "+age.size )
    println("********************************************************");
    var car = arrayListOf<String>("Volvo", "BMW");

    car.add("Opel")

    println("First element of ArrayList is "+car.get(0));
    println("Second element of ArrayList is "+car.get(1));
    println("Third element of ArrayList is "+car.get(2));

    println("*******************************************************************")

    var myMixArrayList = arrayListOf<Any>()
    myMixArrayList.add("Hello")
    myMixArrayList.add(2)
    myMixArrayList.add(2.5)
    myMixArrayList.add(true)
    myMixArrayList.add('k')

    println(myMixArrayList[0])
    println(myMixArrayList[1])
    println(myMixArrayList[2])
    println(myMixArrayList[3])
    println(myMixArrayList[4])


}