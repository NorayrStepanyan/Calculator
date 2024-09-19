package com.example.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //        //numbers
        val buttonZero = findViewById<TextView>(R.id.buttonZero)
        val buttonOne = findViewById<TextView>(R.id.buttonOne)
        val buttonTwo = findViewById<TextView>(R.id.buttonTwo)
        val buttonThree = findViewById<TextView>(R.id.buttonThree)
        val buttonFour = findViewById<TextView>(R.id.buttonFour)
        val buttonFive = findViewById<TextView>(R.id.buttonFive)
        val buttonSix = findViewById<TextView>(R.id.buttonSix)
        val buttonSeven = findViewById<TextView>(R.id.buttonSeven)
        val buttonEight = findViewById<TextView>(R.id.buttonEight)
        val buttonI = findViewById<TextView>(R.id.buttonI)
        val textNumbers = findViewById<TextView>(R.id.textNumbers)


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
            textNumbers.text = textNumbers.text.toString().plus("1")
        }
        buttonTwo.setOnClickListener {
            textNumbers.text = textNumbers.text.toString().plus("2")
        }
        buttonThree.setOnClickListener {
            textNumbers.text = textNumbers.text.toString().plus("3")
        }
        buttonFour.setOnClickListener {
            textNumbers.text = textNumbers.text.toString().plus("4")
        }
        buttonFive.setOnClickListener {
            textNumbers.text = textNumbers.text.toString().plus("5")
        }
        buttonSix.setOnClickListener {
            textNumbers.text = textNumbers.text.toString().plus("6")
        }
        buttonSeven.setOnClickListener {
            textNumbers.text = textNumbers.text.toString().plus("7")
        }
        buttonEight.setOnClickListener {
            textNumbers.text = textNumbers.text.toString().plus("8")
        }
        buttonI.setOnClickListener {
            textNumbers.text = textNumbers.text.toString().plus("9")
        }
        buttonZero.setOnClickListener {
            textNumbers.text = textNumbers.text.toString().plus("0")
        }


        buttonDot.setOnClickListener {
            if (textNumbers.text.contains(".")) {

            } else if (textNumbers.text.isNotEmpty()) textNumbers.text =
                textNumbers.text.toString().plus(".")
        }


        buttonMinusNum.setOnClickListener {
            val textMin = "-"
            if (textNumbers.text.contains("-") || textNumbers.text.contains("0.0")) {

            } else textNumbers.text = textMin + textNumbers.text
        }

        buttonClear.setOnClickListener {
            textNumbers.text = ""
            pad = 0.0
        }


        buttonDelete.setOnClickListener {
            if (textNumbers.text.isNotEmpty()) {
                textNumbers.text = textNumbers.text.substring(0, textNumbers.length() - 1)
            }
        }


        buttonPlus.setOnClickListener {
            if (textNumbers.text.isNotEmpty() && pad == 0.0) {
                pad = textNumbers.text.toString().toDouble()
                textNumbers.text = ""
            } else if (textNumbers.text.isNotEmpty() && pad != 0.0) {
                pad += textNumbers.text.toString().toDouble()
                textNumbers.text = ""
            }
            buttonValue.setOnClickListener {
                if (textNumbers.text.contains("-")) {

                } else if (textNumbers.text.isNotEmpty()) {
                    plus(textNumbers, pad)
                    pad = 0.0
                } else if (textNumbers.text.isEmpty() && pad != 0.0) {
                    textNumbers.text = pad.toString()
                }
            }

        }


        buttonMinus.setOnClickListener {
            if (textNumbers.text.isNotEmpty() && pad == 0.0) {
                pad = textNumbers.text.toString().toDouble()
                textNumbers.text = ""
            } else if (textNumbers.text.isNotEmpty() && pad != 0.0) {
                pad -= textNumbers.text.toString().toDouble()
                textNumbers.text = ""
            }
            buttonValue.setOnClickListener {
                if (textNumbers.text.isNotEmpty()) {
                    minus(textNumbers, pad)
                    pad = 0.0
                } else if (textNumbers.text.isEmpty() && pad != 0.0) {
                    textNumbers.text = pad.toString()
                }
            }
        }


        buttonMultiplication.setOnClickListener {
            if (textNumbers.text.isNotEmpty() && pad == 0.0) {
                pad = textNumbers.text.toString().toDouble()
                textNumbers.text = ""
            } else if (textNumbers.text.isNotEmpty() && pad != 0.0) {
                pad *= textNumbers.text.toString().toDouble()
                textNumbers.text = ""
            }
            buttonValue.setOnClickListener {
                if (textNumbers.text.isNotEmpty()) {
                    multiplication(textNumbers, pad)
                    pad = 0.0
                } else if (textNumbers.text.isEmpty() && pad != 0.0) {
                    textNumbers.text = pad.toString()
                }
            }
        }


        buttonSeparation.setOnClickListener {
            if (textNumbers.text.isNotEmpty() && pad == 0.0) {
                pad = textNumbers.text.toString().toDouble()
                textNumbers.text = ""
            } else if (textNumbers.text.isNotEmpty() && pad != 0.0) {
                pad /= textNumbers.text.toString().toDouble()
                textNumbers.text = ""
            }
            buttonValue.setOnClickListener {
                if (textNumbers.text.isNotEmpty()) {
                    separation(textNumbers, pad)
                    pad = 0.0
                } else if (textNumbers.text.isEmpty() && pad != 0.0) {
                    textNumbers.text = pad.toString()
                }
            }
        }


        buttonPercent.setOnClickListener {
            if (textNumbers.text.isNotEmpty() && pad == 0.0) {
                pad = textNumbers.text.toString().toDouble()
                textNumbers.text = ""
            } else if (textNumbers.text.isNotEmpty() && pad != 0.0) {
                pad %= textNumbers.text.toString().toDouble()
                textNumbers.text = ""
            }
            buttonValue.setOnClickListener {
                if (textNumbers.text.isNotEmpty()) {
                    percent(textNumbers, pad)
                    pad = 0.0
                } else if (textNumbers.text.isEmpty() && pad != 0.0) {
                    textNumbers.text = pad.toString()
                }
            }
        }

    }
}