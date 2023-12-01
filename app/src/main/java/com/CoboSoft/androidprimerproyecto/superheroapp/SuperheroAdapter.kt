package com.CoboSoft.androidprimerproyecto.superheroapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.CoboSoft.androidprimerproyecto.R

class SuperheroAdapter(var superHeroList: List<SuperheroItemResponse> = emptyList(), private val onItemSelected:(String)->Unit ) :
    RecyclerView.Adapter<SuperheroViewHolder>() {


    fun updateList(superHeroList: List<SuperheroItemResponse>) {

        this.superHeroList = superHeroList
        notifyDataSetChanged()

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        return SuperheroViewHolder(layoutInflater.inflate(R.layout.item_superhero, parent, false))


    }

    override fun getItemCount(): Int {
        return superHeroList.size
    }

    override fun onBindViewHolder(viewholder: SuperheroViewHolder, position: Int) {

        viewholder.bind(superHeroList[position], onItemSelected)
    }
}