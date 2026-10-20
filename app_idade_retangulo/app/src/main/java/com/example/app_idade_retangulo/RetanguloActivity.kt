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

class RetanguloActivity : AppCompatActivity() {
    //Declare os id´s dos componentes da activity_main aqui
    private lateinit var edBase: EditText
    private lateinit var edAltura: EditText
    private lateinit var tvResultado: TextView
    private lateinit var btCalcular: Button
    private lateinit var btLimpar: Button
    private lateinit var btSair: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_retangulo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Associe as variáveis com os componentes dda tela
        edBase = findViewById<EditText>(R.id.edBase);
        edAltura = findViewById<EditText>(R.id.edAltura);
        tvResultado = findViewById< TextView>(R.id.tvResultado);
        btCalcular = findViewById<Button>(R.id.btCalcular);
        btLimpar = findViewById<Button>(R.id.btLimpar);
        btSair = findViewById<Button>(R.id.btSairLogin);

        btCalcular.setOnClickListener{
            //Declaração de variáveis
            var base : Double
            var altura: Double
            var area: Double

            base = edBase.text.toString().toDouble()
            altura = edAltura.text.toString().toDouble()
            area = base * altura
            tvResultado.text = area.toString()
        }

        btLimpar.setOnClickListener{
            edBase.setText("")
            edAltura.setText("")
        }
        btSair.setOnClickListener{
            finishAndRemoveTask()
        }



    }
}