package com.CoboSoft.androidprimerproyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.CoboSoft.androidprimerproyecto.FristApp.FirstAppActivity
import com.CoboSoft.androidprimerproyecto.IMCCalculator.ImcCalculatorActivity
import com.CoboSoft.androidprimerproyecto.Settings.SettingsActivity
import com.CoboSoft.androidprimerproyecto.ToDoApp.ToDoActivity
import com.CoboSoft.androidprimerproyecto.superheroapp.SuperHeroListActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnSaludos=findViewById<AppCompatButton>(R.id.btnSaludos)
        val btnIMCApp=findViewById<AppCompatButton>(R.id.btnIMCApp)
        val btnToDo=findViewById<AppCompatButton>(R.id.btnToDo)
        val btnToSuperHero=findViewById<AppCompatButton>(R.id.btnToSuperHero)
        val btnToSettings = findViewById<AppCompatButton>(R.id.btnToSettings)

        btnSaludos.setOnClickListener{navigateToSaludar()}
        btnIMCApp.setOnClickListener{navigateToIMCApp()}
        btnToDo.setOnClickListener { navigateToDoApp() }
        btnToSuperHero.setOnClickListener { navigateToSuperHeroApp()}
        btnToSettings.setOnClickListener { navigateToSettings() }

    }

    private fun navigateToDoApp() {

        val intent= Intent(this,ToDoActivity::class.java)
        startActivity(intent);

    }

    private fun navigateToIMCApp() {

        val intent= Intent(this,ImcCalculatorActivity::class.java)
        startActivity(intent);
    }

    private fun navigateToSaludar(){
         val intent= Intent(this, FirstAppActivity::class.java)
        startActivity(intent);


    }


    private fun navigateToSuperHeroApp(){
        val intent= Intent(this, SuperHeroListActivity::class.java)
        startActivity(intent);


    }


    private fun navigateToSettings(){
        val intent= Intent(this, SettingsActivity::class.java)
        startActivity(intent);


    }

}