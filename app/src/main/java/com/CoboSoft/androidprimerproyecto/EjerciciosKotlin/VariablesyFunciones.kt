package com.CoboSoft.androidprimerproyecto.EjerciciosKotlin

fun main() {

    val edad: Long = 30;
    var edad2: Int = 29
    edad2 = 34;
    val example: Long = 21122121;
    val resta = restar(4, 4)

    //print(edad2);
    addNumeros(8, 3);

    println(resta);
}


fun ejemploDeFuncion() {

}

fun addNumeros(firstNumber: Int, SecondNumber: Int) {
    val resultado = firstNumber + SecondNumber;
    println((resultado))
}

fun restar(firstNumber: Int, SecondNumber: Int): Int {

    return firstNumber - SecondNumber;

}

