package com.CoboSoft.androidprimerproyecto.FristApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.CoboSoft.androidprimerproyecto.R

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val textResult= findViewById<TextView>(R.id.textViewResult)
        val name:String = intent.extras?.getString("Extra_Name").orEmpty(); // Hcaerlo Nulable con ? y sino tienen nada darlo vacio
        textResult.text="Hola $name como te encuentras";
    }
}