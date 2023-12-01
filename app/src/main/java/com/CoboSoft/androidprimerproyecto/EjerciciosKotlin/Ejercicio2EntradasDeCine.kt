package com.CoboSoft.androidprimerproyecto.EjerciciosKotlin

/** Las entradas de cine suelen tener un precio diferente según la edad de los espectadores.

En el código inicial que se proporciona en el siguiente fragmento de código, escribe un programa que calcule los precios de estas entradas basados en la edad:

Un precio de entrada infantil de USD 15 para personas de 12 años o menos.
Un precio de entrada estándar de USD 30 para personas de entre 13 y 60 años. Los lunes, un precio estándar con descuento de USD 25 para el mismo grupo etario
Un precio para adultos mayores de USD 20 para personas de 61 años o más (asumimos que la edad máxima de un espectador es de 100 años)
Un valor de -1 para indicar que el precio no es válido cuando un usuario ingresa una edad fuera de las especificaciones **/


fun main() {
    val child = 4
    val adult = 28
    val senior = 87

    val isMonday = true

    println("The movie ticket price for a person aged $child is \$${ticketPrice(child, isMonday)}.")
    println("The movie ticket price for a person aged $adult is \$${ticketPrice(adult, isMonday)}.")
    println(
        "The movie ticket price for a person aged $senior is \$${
            ticketPrice(
                senior,
                isMonday
            )
        }."
    )
}

fun ticketPrice(age: Int, isMonday: Boolean): Int {

    var precio: Int = 0;

    if (age < 1) {
        precio = -1;
    }
    if (age in 14..59 && isMonday) {
        precio = 25;
    } else{
        precio=30;
    }
    if (age > 61) {
        precio = 20
    }
    if (age < 12) {
        precio = 15;
    }

    return precio;


}