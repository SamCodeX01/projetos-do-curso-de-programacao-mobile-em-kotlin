package com.example.app_idade_retangulo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TelaBotoesActivity : AppCompatActivity() {
    private lateinit var btIdade: Button
    private lateinit var btRetangulo: Button
    private lateinit var btFinalizar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tela_botoes)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btIdade = findViewById<Button>(R.id.btIdade)
        btRetangulo = findViewById<Button>(R.id.btRetangulo)
        btFinalizar = findViewById<Button>(R.id.btFinalizar)

        btIdade.setOnClickListener {
            val intent = Intent(this, IdadeActivity::class.java)
            startActivity(intent)
        }

        btRetangulo.setOnClickListener {
            val intent = Intent(this, RetanguloActivity::class.java)
            startActivity(intent)
        }

        btFinalizar.setOnClickListener {
            finishAffinity()
            //System.exit(0) // Força o encerramento do processo (opcional)

        }


    }
}