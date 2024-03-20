package com.example.myintents
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var editTextNumber1: EditText
    private lateinit var editTextNumber2: EditText
    private lateinit var textViewResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextNumber1 = findViewById(R.id.editTextNumber1)
        editTextNumber2 = findViewById(R.id.editTextNumber2)
        textViewResult = findViewById(R.id.textViewResult)

        val buttonAdd: Button = findViewById(R.id.buttonAdd)
        val buttonSubtract: Button = findViewById(R.id.buttonSubtract)
        val buttonMultiply: Button = findViewById(R.id.buttonMultiply)
        val buttonDivide: Button = findViewById(R.id.buttonDivide)

        buttonAdd.setOnClickListener { calculate(it) }
        buttonSubtract.setOnClickListener { calculate(it) }
        buttonMultiply.setOnClickListener { calculate(it) }
        buttonDivide.setOnClickListener { calculate(it) }
    }

    fun calculate(view: View) {
        val num1 = editTextNumber1.text.toString().toDouble()
        val num2 = editTextNumber2.text.toString().toDouble()
        var result = 0.0

        when (view.id) {
            R.id.buttonAdd -> result = num1 + num2
            R.id.buttonSubtract -> result = num1 - num2
            R.id.buttonMultiply -> result = num1 * num2
            R.id.buttonDivide -> {
                if (num2 != 0.0) {
                    result = num1 / num2
                } else {
                    textViewResult.text = "Cannot divide by zero"
                    return
                }
            }
        }

        textViewResult.text = "Result: $result"
    }
}
