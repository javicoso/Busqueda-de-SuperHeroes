package com.CoboSoft.androidprimerproyecto.EjerciciosKotlin

/**En el mundo, se usan tres escalas de temperatura principales: Celsius, Fahrenheit y Kelvin.

En el código inicial que se proporciona en el siguiente fragmento de código, escribe un programa que convierta una temperatura de una escala a otra con estas fórmulas:

De grados Celsius a Fahrenheit: °F = 9/5 (°C) + 32
Kelvin a Celsius: °C = K - 273.15
De Fahrenheit a Kelvin: K = 5/9 (°F - 32) + 273.15
Ten en cuenta que el método String.format("%.2f", /* measurement */ ) se usa para convertir un número en un tipo String con 2 decimales.**/

fun main() {
    printFinalTemperature(27.0,"Celsius","Fahrenheit",)
    printFinalTemperature(350.0,"Kelvin","Celsius",)
    printFinalTemperature(10.0,"Fahrenheit","Kelvin",)
}

fun printFinalTemperature(
    initialMeasurement: Double,
    initialUnit: String,
    finalUnit: String,

)
{

    if(initialUnit=="Celsius"&&finalUnit=="Fahrenheit"){
        val finalMeasurement = String.format("%.2f", ((initialMeasurement)*9/5)+32);// two decimal places
        println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")

    }
    if(initialUnit=="Kelvin"&&finalUnit=="Celsius"){
        val finalMeasurement = String.format("%.2f", (initialMeasurement)-273.15);// two decimal places
        println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")

    }

    if(initialUnit=="Fahrenheit"&&finalUnit=="Kelvin"){
        val finalMeasurement = String.format("%.2f", (((initialMeasurement)-32)*5/9)+273.15);// two decimal places
        println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")

    }


}