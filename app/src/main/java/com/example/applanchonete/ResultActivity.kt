package com.example.applanchonete

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity (){
    private lateinit var resultadoTextView: TextView
    private lateinit var voltarBotao: Button
    private lateinit var coxinhaQuantidadeTextView: TextView
    private lateinit var cervejaQuantidadeTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        resultadoTextView = findViewById(R.id.textViewResultado)
        voltarBotao = findViewById(R.id.backButton)
        coxinhaQuantidadeTextView = findViewById(R.id.textViewCoxinha)
        cervejaQuantidadeTextView = findViewById(R.id.textViewCerveja)

        val coxinhaQuantidade = intent.getIntExtra(lblCoxinha, 0)
        val cervejaQuantidade = intent.getIntExtra(lblCerveja, 0)

        val total = calculateTotal(coxinhaQuantidade, cervejaQuantidade)

        resultadoTextView.text = "Total a pagar: R$ $total"
        coxinhaQuantidadeTextView.text = "Quantidade de coxinhas: $coxinhaQuantidade"
        cervejaQuantidadeTextView.text = "Quantidade de cervejas: $cervejaQuantidade"

        voltarBotao.setOnClickListener{
            finish()
        }
    }

    private fun calculateTotal(coxinhaQuantidade: Int, cervejaQuantidade: Int): Double {
        val coxinhaPrice = 10.0
        val cervejaPrice = 15.0
        val taxaServico = 0.10

        val totalCoxinha = coxinhaQuantidade * coxinhaPrice
        val totalCerveja = cervejaQuantidade * cervejaPrice
        val subtotal = totalCoxinha + totalCerveja
        val totalComTaxa = subtotal + (subtotal + taxaServico)

        return totalComTaxa
    }

    companion object {
        const val lblCoxinha = "lbl_coxinha"
        const val lblCerveja = "lbl_cerveja"
    }


}