package com.CoboSoft.androidprimerproyecto.superheroapp

import android.annotation.SuppressLint
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.View
import androidx.core.view.isVisible
import com.CoboSoft.androidprimerproyecto.R
import com.CoboSoft.androidprimerproyecto.databinding.ActivityDetailSuperheroBinding
import com.CoboSoft.androidprimerproyecto.databinding.ActivitySuperHeroListBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.roundToInt

class DetailSuperheroActivity : AppCompatActivity() {


    companion object{
        const val ESTRA_ID="extra_id"
    }

    private lateinit var binding: ActivityDetailSuperheroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetailSuperheroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val id = intent.getStringExtra(ESTRA_ID).orEmpty()
        getSuperheroInformation(id)
    }


    private fun getSuperheroInformation(id: String) {

        CoroutineScope(Dispatchers.IO).launch {
          val superheroDetail=  getRetrofit().create(ApiService::class.java).getSuperheroDetail(id)

            if(superheroDetail.body()!=null){
                runOnUiThread { createdUI( superheroDetail.body()!!) }
              
            }

        }

    }

    private fun createdUI(superhero: SuperHeroDetailResponse) {
        Picasso.get().load(superhero.image.url).into(binding.ivSuperhero)
        binding.tvSuperheroName.text=superhero.name
        prepareStats(superhero.powerstats)
        binding.tvSuperheroRealName.text=superhero.biography.fullname
        binding.tvSuperheroPublisher.text=superhero.biography.publisher
        binding.tvFirstAppearance.text=superhero.biography.firstAppearance


    }

    private fun prepareStats(powerstats: SuperPowerStatsResponse) {

        updateHeight(binding.viewIntelligence,powerstats.intelligence)
        updateHeight(binding.viewDurability,powerstats.durability)
        updateHeight(binding.viewPower,powerstats.power)
        updateHeight(binding.viewSpeed,powerstats.speed)
        updateHeight(binding.viewStrength,powerstats.strength)
        updateHeight(binding.viewCombat,powerstats.combat)

    }

    private fun updateHeight(view: View, stat:String){

        val params=view.layoutParams
        params.height=pxToDp(stat.toFloat())
        view.layoutParams=params;

    }

    private fun pxToDp(px:Float):Int{

        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,px,resources.displayMetrics).roundToInt()

    }


    private fun getRetrofit(): Retrofit {

        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}