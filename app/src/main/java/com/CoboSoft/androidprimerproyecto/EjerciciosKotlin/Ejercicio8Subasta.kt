package com.CoboSoft.androidprimerproyecto.EjerciciosKotlin


/** Por lo general, en una subasta, el ofertante que ofrece el importe más alto determina el precio de un artículo. En esta subasta especial, si nadie oferta por un artículo, este se vende automáticamente a la casa de subastas al precio mínimo.

En el código inicial que se proporciona en el siguiente fragmento de código, se te proporciona una función auctionPrice() que acepta un tipo Bid? anulable como argumento: **/

fun main() {
    val winningBid = Bid(6000, "Private Collector")

    println("Item A is sold at ${auctionPrice(winningBid, 2000)}.")
    println("Item B is sold at ${auctionPrice(null, 3000)}.")
}

 class Bid(val amount: Int, val bidder: String)

fun auctionPrice(bid: Bid?, minimumPrice: Int): Int {

    var precio:Int=0
    if(bid==null){
       precio=minimumPrice;
    }else{
       precio=bid.amount;
    }
    return precio;

}

