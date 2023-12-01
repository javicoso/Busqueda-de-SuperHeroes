package com.CoboSoft.androidprimerproyecto.IMCCalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.CoboSoft.androidprimerproyecto.IMCCalculator.ImcCalculatorActivity.Companion.IMC_KEY
import com.CoboSoft.androidprimerproyecto.R

class ResultIMCActivity : AppCompatActivity() {

    private lateinit var tvResult:TextView
    private lateinit var tvIMC:TextView
    private lateinit var tvDescription:TextView

    private lateinit var btnRecalculate:Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imcactivity)

        val result = intent.extras?.getDouble(IMC_KEY)?:-1.0

        initComponent()
        initUI(result)
        initListener()

    }

    private fun initListener() {
        btnRecalculate.setOnClickListener { onBackPressed()}
    }

    private fun initUI(result: Double) {

        tvIMC.text=result.toString()
        when(result){
            in 0.00..18.50->{ //Bajo Peso
                tvResult.text = getString(R.string.title_bajo_peso)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.resultBajo))

                tvDescription.text= getString(R.string.description_bajo_peso)

            }

            in 18.51..24.99->{ //Peso normal
                tvResult.text = getString(R.string.title_normal_peso)

                tvResult.setTextColor(ContextCompat.getColor(this, R.color.resulNormal))

                tvDescription.text =getString(R.string.description_normal)

            }

            in 25.00..29.99->{ //Sobrepeso
                tvResult.text = getString(R.string.title_sobrepeso)

                tvResult.setTextColor(ContextCompat.getColor(this, R.color.resultAlto))

                tvDescription.text = getString(R.string.description_sobrepeso)

            }

            in 30.00..99.99->{ //Obesidad
                tvResult.text = getString(R.string.title_Obesidad)

                tvResult.setTextColor(ContextCompat.getColor(this, R.color.resulObeso))

                tvDescription.text = getString(R.string.description_Obesidad)

            }

            else->{

                tvResult.text=getString(R.string.error)
                tvIMC.text=getString(R.string.error)
                tvDescription.text=getString(R.string.error)

            }
        }

    }

    private fun initComponent() {
        tvResult= findViewById(R.id.tvResult)
        tvIMC= findViewById(R.id.tvIMC)
        tvDescription= findViewById(R.id.tvDescription)
        btnRecalculate=findViewById(R.id.btnRecalculate)
    }
}