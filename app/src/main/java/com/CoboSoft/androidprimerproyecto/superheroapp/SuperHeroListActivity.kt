package com.CoboSoft.androidprimerproyecto.superheroapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.CoboSoft.androidprimerproyecto.databinding.ActivitySuperHeroListBinding
import com.CoboSoft.androidprimerproyecto.superheroapp.DetailSuperheroActivity.Companion.ESTRA_ID
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SuperHeroListActivity : AppCompatActivity() {


    private lateinit var binding: ActivitySuperHeroListBinding

    private lateinit var retrofit: Retrofit


    private lateinit var adapter: SuperheroAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuperHeroListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofit = getRetrofit()
        initUI()
    }

    private fun initUI() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {

                searchByName(query.orEmpty())
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })

        adapter= SuperheroAdapter(){ navigateToDetail(it)}
        binding.rvSuperHero.setHasFixedSize(true)
        binding.rvSuperHero.layoutManager= LinearLayoutManager(this)
        binding.rvSuperHero.adapter=adapter;

    }

    private fun searchByName(query: String) {

        binding.progressBar.isVisible = true
        //Ejemplo de Corrutina
        CoroutineScope(Dispatchers.IO).launch {

            val myResponse: Response<SuperDataHeroResponse> =
                retrofit.create(ApiService::class.java).getSuperheroes(query)

            if (myResponse.isSuccessful) {
                Log.i("cobosoft", "funciona")
                val response: SuperDataHeroResponse? = myResponse.body()
                if (response != null) {
                    Log.i("cobosoft", response.toString())
                    runOnUiThread {
                        adapter.updateList(response.superheroes)
                        binding.progressBar.isVisible = false
                    }
                }
            } else {
                Log.i("cobosoft", " No funciona")
            }
        }
    }

    private fun getRetrofit(): Retrofit {

        return Retrofit.Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    private fun navigateToDetail(id:String){
        val intent= Intent(this, DetailSuperheroActivity::class.java)
        intent.putExtra(ESTRA_ID, id)
        startActivity(intent)
    }


}