package com.example.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.simplecalculator.databinding.ActivityMainBinding
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

lateinit var binding : ActivityMainBinding


class MainActivity<TextInputLayout, MaterialButton> : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val firstNumberEditText: TextInputEditText = binding.firstNumberLayout.editText as TextInputEditText
        val secondNumberEditText: TextInputEditText = binding.secondNumberLayout.editText as TextInputEditText
        val resultTextView: TextView = binding.resultTextView

        val addButton: com.google.android.material.button.MaterialButton = binding.btnAdd
        val subtractButton: com.google.android.material.button.MaterialButton = binding.btnSub
        val multiplyButton: com.google.android.material.button.MaterialButton = binding.btnMultiply
        val divisionButton: com.google.android.material.button.MaterialButton = binding.btnDivision

        addButton.setOnClickListener {
            performCalculation(firstNumberEditText.text.toString(), secondNumberEditText.text.toString(), '+', resultTextView)
        }

        subtractButton.setOnClickListener {
            performCalculation(firstNumberEditText.text.toString(), secondNumberEditText.text.toString(), '-', resultTextView)
        }

        multiplyButton.setOnClickListener {
            performCalculation(firstNumberEditText.text.toString(), secondNumberEditText.text.toString(), '*', resultTextView)
        }

        divisionButton.setOnClickListener {
            performCalculation(firstNumberEditText.text.toString(), secondNumberEditText.text.toString(), '/', resultTextView)
        }
    }

    private fun performCalculation(firstNumberText: String, secondNumberText: String, operator: Char, resultTextView: TextView) {
        if (firstNumberText.isEmpty() || secondNumberText.isEmpty()) {
            resultTextView.text = "Please enter both numbers"
        } else {
            try {
                val firstNumber = firstNumberText.toDouble()
                val secondNumber = secondNumberText.toDouble()
                val result = when (operator) {
                    '+' -> firstNumber + secondNumber
                    '-' -> firstNumber - secondNumber
                    '*' -> firstNumber * secondNumber
                    '/' -> if (secondNumber != 0.0) firstNumber / secondNumber else Double.POSITIVE_INFINITY
                    else -> 0.0
                }
                resultTextView.text = "Result  = $result"
            } catch (e: NumberFormatException) {
                resultTextView.text = "Invalid input. Please enter numbers."
            }
        }
    }
}


