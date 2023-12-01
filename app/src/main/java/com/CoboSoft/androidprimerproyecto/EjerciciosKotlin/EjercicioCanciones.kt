package com.CoboSoft.androidprimerproyecto.EjerciciosKotlin

fun main(){


var cancion1= Canciones();
    var cancion2= Canciones();


    cancion1.artista="Alex Ubago";
    cancion1.titulo="Te he perdido";
    cancion1.añoDePublicacion=2023;
    cancion1.recuentoRepro=200000;
    cancion1.Imprimir();
    cancion1.popularidad();


    cancion2.artista="Pitingo";
    cancion2.titulo="Te has ido";
    cancion2.añoDePublicacion=2019;
    cancion2.recuentoRepro=22;
    cancion2.Imprimir();
    cancion2.popularidad();

}

class Canciones{

    //Propiedades para el título, el artista, el año de publicación y el recuento de reproducciones

    var titulo:String="";
    var artista:String="";
    var añoDePublicacion:Int=0;
    var recuentoRepro:Int=0;
    var popularidad:Boolean= true


    fun popularidad(){
        if(recuentoRepro>1000){
            popularidad=true
            println("Es popular")
        }else{
            println("No es popular")
        }
    }

    fun Imprimir(){
        println("$titulo, interpretada por $artista, se lanzó en $añoDePublicacion")
    }




}