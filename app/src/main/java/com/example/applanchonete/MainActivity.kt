package com.example.applanchonete

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

        private lateinit var coxinhaEditText: EditText
        private lateinit var cervejaEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        coxinhaEditText = findViewById(R.id.editTextCoxinha)
        cervejaEditText = findViewById(R.id.editTextCerveja)
        val calculateButton: Button = findViewById(R.id.calculateButton)
        calculateButton.setOnClickListener{
            calculateAndShowResult()
        }
    }

    private fun calculateAndShowResult() {
        val coxinhaInput = coxinhaEditText.text.toString()
        val cervejaInput = coxinhaEditText.text.toString()

        if(coxinhaInput.isNotEmpty() && cervejaInput.isNotEmpty()){
                val coxinhaQuantity = coxinhaInput.toInt()
                val cervejaQuantity = cervejaInput.toInt()

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra(ResultActivity.lblCoxinha, coxinhaQuantity)
                 intent.putExtra(ResultActivity.lblCerveja, cervejaQuantity)
        } else {
            Toast.makeText(this,"Preencha todos os campos", Toast.LENGTH_SHORT).show()
        }
    }
}