package com.definelab.firstkotlinprogram
/*
toByte()
toShort()
toInt()
toLong()
toFloat()
toDouble()
toChar()
*/

fun main(args: Array<String>) {

/*
   //Type Coversion Smallest To largest(No data Loss)
    var x: Byte = 127;
    var y: Int = x.toInt();

    var z: Double = y.toDouble();

    println(x);
    println(y);
    println(z);
*/
    //Type Coversion Largest To Smallest(Data Loss)
    var a: Double = 132.32;
    var b: Int = a.toInt();
    var c: Byte = b.toByte();

    println(a);
    println(b);
    println(c);

}