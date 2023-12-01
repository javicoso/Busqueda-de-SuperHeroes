package com.CoboSoft.androidprimerproyecto.EjerciciosKotlin

fun main() {
    val amanda = Person("Amanda", 33, "play tennis", null)
    val atiqah = Person("Atiqah", 28, "climb", amanda)

    amanda.showProfile()
    println("");
    println("");
    atiqah.showProfile()
}

class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?) {
    fun showProfile() {
        println("Name: $name");
        println("Edad: $age");
        if(hobby!=null) {
            print("Likes to $hobby .");
        }
        if(referrer!=null) {
            print("Has a referrer named ${referrer.name}, who likes to ${referrer.hobby}.");
        }else{
            print("Doesn't have a referrer")
        }

    }
}