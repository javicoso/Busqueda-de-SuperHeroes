package com.CoboSoft.androidprimerproyecto.FristApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.CoboSoft.androidprimerproyecto.R

class FirstAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_app)
        val btnStart=findViewById<AppCompatButton>(R.id.btnStart)
        val etName=findViewById<AppCompatEditText>(R.id.etName)
        etName.text.toString()
        btnStart.setOnClickListener {
            val name = etName.text.toString()

            if(name.isNotEmpty()){
                //Log.i("CoboSoft","Button Pulsado $name");

                val intent = Intent(this,ResultActivity::class.java) //Ejemplo de Intent
                intent.putExtra("Extra_Name", name);
                startActivity(intent);
            }
        }


    }
}