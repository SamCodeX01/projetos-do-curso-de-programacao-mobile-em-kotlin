package com.example.app_idade_retangulo

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class IdadeActivity : AppCompatActivity() {
    private lateinit var edAnoAtual: EditText
    private lateinit var edAnoNasc: EditText
    private lateinit var tvAnos: TextView
    private lateinit var tvMeses: TextView
    private lateinit var tvDias: TextView
    private lateinit var tvHoras: TextView
    private lateinit var tvMinutos: TextView
    private lateinit var tvSegundos: TextView
    private lateinit var btCalcularr: Button
    private lateinit var btLimparr: Button
    private lateinit var btSairr: Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_idade)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        edAnoAtual = findViewById<EditText>(R.id.edAnoAtual)
        edAnoNasc = findViewById<EditText>(R.id.edAnoNasc)
        tvAnos = findViewById<TextView>(R.id.tvAnos)
        tvMeses = findViewById<TextView>(R.id.tvMeses)
        tvDias = findViewById<TextView>(R.id.tvDias)
        tvHoras = findViewById<TextView>(R.id.tvHoras)
        tvMinutos = findViewById<TextView>(R.id.tvMinutos)
        tvSegundos = findViewById<TextView>(R.id.tvSegundos)
        btCalcularr = findViewById<Button>(R.id.btCalcularr)
        btLimparr = findViewById<Button>(R.id.btLimparr)
        btSairr = findViewById<Button>(R.id.btSairr)


        btCalcularr.setOnClickListener {
            val anoAtual : Int
            val anoNasc : Int
            val resultAnos : Int
            val resultMeses : Int
            val resultDias : Int
            val resultHoras : Int
            val resultMinutos : Int
            val resultSegundos : Int

            anoAtual = edAnoAtual.text.toString().trim().toIntOrNull() ?: 0 //O operador Elvis ?:, pergunto "E se for nulo?" o lado esquerdo, se for atribua o 0
            anoNasc = edAnoNasc.text.toString().trim().toIntOrNull() ?: 0

            resultAnos = anoAtual - anoNasc
            tvAnos.setText(resultAnos.toString())

            resultMeses = resultAnos * 12
            tvMeses.setText(resultMeses.toString())

            resultDias = resultAnos * 12 * 365
            tvDias.setText(resultDias.toString())

            resultHoras = resultAnos * 12 * 365 * 24
            tvHoras.setText(resultHoras.toString())

            resultMinutos = resultAnos * 12 * 365 * 24 * 60
            tvMinutos.setText(resultMinutos.toString())

            resultSegundos = resultAnos * 12 * 365 * 24 * 60 * 60
            tvSegundos.setText(resultSegundos.toString())

        }


        btLimparr.setOnClickListener {
            edAnoAtual.setText("")
            edAnoNasc.setText("")
            tvAnos.setText("")
            tvMeses.setText("")
            tvDias.setText("")
            tvHoras.setText("")
            tvMinutos.setText("")
            tvSegundos.setText("")
        }
        btSairr.setOnClickListener {
            finishAndRemoveTask()
        }
    }
}