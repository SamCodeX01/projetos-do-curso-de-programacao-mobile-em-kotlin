package com.example.app_idade_retangulo

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    private lateinit var edUsuario: EditText
    private lateinit var edSenha: EditText
    private lateinit var btAcessar: Button
    private lateinit var btSairLogin: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 1. Encontrar os componentes do XML pelo ID
        val edUsuario = findViewById<EditText>(R.id.edUsuario)
        val edSenha = findViewById<EditText>(R.id.edSenha)
        val btAcessar = findViewById<Button>(R.id.btAcessar)
        val btSairLogin = findViewById<Button>(R.id.btSairLogin)

        // 2. Configurar o clique do botão
        btAcessar.setOnClickListener {
            val usuario = edUsuario.text.toString().trim()
            val senha = edSenha.text.toString().trim()

            // 3. Validação simples (Exemplo: usuário "admin" e senha "1234")
            if (usuario == "admin" && senha == "1234") {
                // Ir para a próxima Activity
                val intent = Intent(this, TelaBotoesActivity::class.java)
                startActivity(intent)
                finish() // Opcional: fecha a tela de login para o usuário não voltar nela ao apertar "Voltar"
            } else {
                // Mostrar mensagem de erro se estiver incorreto ou vazio
                Toast.makeText(this, "Usuário ou senha incorretos!", Toast.LENGTH_SHORT).show()
            }

            btSairLogin.setOnClickListener {
                finishAffinity()
                System.exit(0) // Força o encerramento do processo (opcional)

            }

        }
    }
}