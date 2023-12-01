package com.CoboSoft.androidprimerproyecto.IMCCalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.CoboSoft.androidprimerproyecto.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class ImcCalculatorActivity : AppCompatActivity() {

    private var isMaleSelected: Boolean = true;
    private var isFemaleSelected: Boolean = false;
    private var currentWeight: Int = 60;
    private var currentAge: Int = 24;
    private  var currentHeight:Int=120




    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView
    private lateinit var tvHeight: TextView
    private lateinit var rsHeight: RangeSlider

    private lateinit var btnSubtractWeight: FloatingActionButton
    private lateinit var btnPlusWeight: FloatingActionButton
    private lateinit var tvWeight: TextView

    private lateinit var btnSubtractAge: FloatingActionButton
    private lateinit var btnPlusAge: FloatingActionButton
    private lateinit var tvAge: TextView

    private lateinit var btnCalculate:Button

    companion object{
        const val IMC_KEY="IMC_RESULT"
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_calculator)
        initComponents()
        initListener()
        initUI()

    }


    private fun initComponents() {

        viewMale = findViewById(R.id.viewMale);
        viewFemale = findViewById(R.id.viewFemale);

        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight);

        tvWeight = findViewById(R.id.tvWeight);
        btnPlusWeight = findViewById(R.id.btnPlusWeight);
        btnSubtractWeight = findViewById(R.id.btnSubtractWeight);


        tvAge = findViewById(R.id.tvAge);
        btnPlusAge = findViewById(R.id.btnPlusAge);
        btnSubtractAge = findViewById(R.id.btnSubtractAge);

        btnCalculate=findViewById(R.id.btnCalculate);

    }

    private fun initListener() {

        viewMale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        viewFemale.setOnClickListener {

            changeGender()
            setGenderColor()
        }

        rsHeight.addOnChangeListener { _, value, _ ->

            val df = DecimalFormat("#.##")
            currentHeight= df.format(value).toInt();
            tvHeight.text = "$currentHeight cm";
        }

        btnPlusWeight.setOnClickListener {

            currentWeight+=1;
            SetWeight()

        }
        btnSubtractWeight.setOnClickListener {
            currentWeight-=1;
            SetWeight()
        }

        btnPlusAge.setOnClickListener {

            currentAge+=1;
            SetAge()

        }

        btnSubtractAge.setOnClickListener {

            currentAge-=1;
            SetAge()
        }

        btnCalculate.setOnClickListener{

           val result= calculateIMC();
            navigateToResult(result);


        }


    }

    private fun navigateToResult(result: Double) {

        val intent= Intent(this, ResultIMCActivity::class.java)
        intent.putExtra(IMC_KEY, result)
        startActivity(intent)

    }

    private fun calculateIMC():Double {
        val df = DecimalFormat("#.##")
       val imc= currentWeight/(currentHeight.toDouble()/100*currentHeight.toDouble()/100)
        return df.format(imc).toDouble();
       // Log.i("CoboSoft","el imc es $result");


    }

    private fun SetAge() {

        tvAge.text=currentAge.toString();

    }

    private fun SetWeight() {

        tvWeight.text=currentWeight.toString();

    }

    private fun changeGender() {

        isMaleSelected = !isMaleSelected;
        isFemaleSelected = !isFemaleSelected;

    }

    private fun setGenderColor() {

        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))

    }

    private fun getBackgroundColor(isSelectedComponenet: Boolean): Int {

        val colorReference = if (isSelectedComponenet) {
            R.color.backGroundButton3
        } else {
            R.color.backGroundButton2
        }

        return ContextCompat.getColor(this, colorReference);

    }

    private fun initUI() {
        setGenderColor();
        SetWeight();
        SetAge();
    }
}