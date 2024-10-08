package com.example.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        //        //numbers
        val buttonZero = findViewById<Button>(R.id.buttonZero)
        val buttonOne = findViewById<Button>(R.id.buttonOne)
        val buttonTwo = findViewById<Button>(R.id.buttonTwo)
        val buttonThree = findViewById<Button>(R.id.buttonThree)
        val buttonFour = findViewById<Button>(R.id.buttonFour)
        val buttonFive = findViewById<Button>(R.id.buttonFive)
        val buttonSix = findViewById<Button>(R.id.buttonSix)
        val buttonSeven = findViewById<Button>(R.id.buttonSeven)
        val buttonEight = findViewById<Button>(R.id.buttonEight)
        val buttonI = findViewById<Button>(R.id.buttonI)
        val textNumbers = findViewById<TextView>(R.id.textNumbers)
        val textAnswer = findViewById<TextView>(R.id.textAnswer)


        //tools
        val buttonPlus = findViewById<TextView>(R.id.buttonPlus)
        val buttonMinus = findViewById<TextView>(R.id.buttonMinus)
        val buttonMultiplication = findViewById<TextView>(R.id.multiplication)
        val buttonSeparation = findViewById<TextView>(R.id.separation)
        val buttonValue = findViewById<TextView>(R.id.buttonValue)
        val buttonClear = findViewById<TextView>(R.id.buttonClear)
        val buttonPercent = findViewById<TextView>(R.id.percent)
        val buttonDot = findViewById<TextView>(R.id.buttonDot)
        val buttonMinusNum = findViewById<TextView>(R.id.buttonMinusNum)
        val buttonDelete = findViewById<TextView>(R.id.deleteOneNum)
        var pad = 0.0


        //buttons
        buttonOne.setOnClickListener {
            textNumbers.text = textNumbers.text.toString() + "1"
        }
        buttonTwo.setOnClickListener {
            textNumbers.text = textNumbers.text.toString() + "2"
        }
        buttonThree.setOnClickListener {
            textNumbers.text = textNumbers.text.toString() + "3"
        }
        buttonFour.setOnClickListener {
            textNumbers.text = textNumbers.text.toString() + "4"
        }
        buttonFive.setOnClickListener {
            textNumbers.text = textNumbers.text.toString() + "5"
        }
        buttonSix.setOnClickListener {
            textNumbers.text = textNumbers.text.toString() + "6"
        }
        buttonSeven.setOnClickListener {
            textNumbers.text = textNumbers.text.toString() + "7"
        }
        buttonEight.setOnClickListener {
            textNumbers.text = textNumbers.text.toString() + "8"
        }
        buttonI.setOnClickListener {
            textNumbers.text = textNumbers.text.toString() + "9"
        }
        buttonZero.setOnClickListener {
            textNumbers.text = textNumbers.text.toString() + "0"
        }

        //tools

        buttonPlus.setOnClickListener {
            textNumbers.text = textNumbers.text.toString().plus("+")
        }
        buttonMinus.setOnClickListener {
            textNumbers.text = textNumbers.text.toString().plus("-")
        }
        buttonMultiplication.setOnClickListener {
            textNumbers.text = textNumbers.text.toString().plus("*")
        }
        buttonSeparation.setOnClickListener {
            textNumbers.text = textNumbers.text.toString().plus("/")
        }
        buttonPercent.setOnClickListener {
            textNumbers.text = textNumbers.text.toString().plus("%")
        }
        buttonValue.setOnClickListener {
            textNumbers.text = textNumbers.text.toString().plus("0")
        }




        buttonDot.setOnClickListener {
            textNumbers.text = textNumbers.text.toString().plus(".")
        }

        buttonMinusNum.setOnClickListener {
            val textMin = "-"
            if (textNumbers.text.contains("-") || textNumbers.text.contains("0.0")) {

            } else textNumbers.text = textMin + textNumbers.text
        }

        buttonDelete.setOnClickListener {
            if (textNumbers.text.isNotEmpty()) {
                textNumbers.text = textNumbers.text.substring(0, textNumbers.length() - 1)
            }
        }
        buttonClear.setOnClickListener {
            textAnswer.text = ""
            textNumbers.text = ""
            pad = 0.0
        }



        buttonValue.setOnClickListener {
            try {
                val value = ExpressionBuilder(textNumbers.text.toString()).build()
                val result = value.evaluate()

                textAnswer.text = textNumbers.text
                textNumbers.text = result.toString()
            } catch (e: Exception) {
                Log.d("error", "null")

            }
        }
    }
}