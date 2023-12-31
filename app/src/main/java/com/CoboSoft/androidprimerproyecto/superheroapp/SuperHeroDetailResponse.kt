package com.CoboSoft.androidprimerproyecto.superheroapp

import com.google.gson.annotations.SerializedName

data class SuperHeroDetailResponse(
    @SerializedName("name") val name: String,
    @SerializedName("powerstats") val powerstats: SuperPowerStatsResponse,
    @SerializedName("image") val image: SuperheroImageDetailResponse,
    @SerializedName("biography") val biography: Biography

)

data class SuperPowerStatsResponse(
    @SerializedName("intelligence") val intelligence: String,
    @SerializedName("strength") val strength: String,
    @SerializedName("speed") val speed: String,
    @SerializedName("durability") val durability: String,
    @SerializedName("power") val power: String,
    @SerializedName("combat") val combat: String
)

data class SuperheroImageDetailResponse( @SerializedName("url") val url: String)

data class Biography(
    @SerializedName("full-name") val fullname: String,
    @SerializedName("publisher") val publisher: String,
    @SerializedName("first-appearance") val firstAppearance: String)



