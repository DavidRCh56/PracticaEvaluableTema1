package com.iesvdc.multimedia.practicaevaluabletema1

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText

class ConfiguracionActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuracion)

        sharedPreferences = getSharedPreferences("MiAppPrefs", MODE_PRIVATE)

        val editTextNombre = findViewById<EditText>(R.id.editTextNombre)
        val btnGuardar = findViewById<Button>(R.id.btnGuardar)
        val btnIrPrincipal = findViewById<Button>(R.id.btnIrPrincipal)

        btnGuardar.setOnClickListener {
            val nombre = editTextNombre.text.toString()
            sharedPreferences.edit().putString("nombre", nombre).apply()
        }

        btnIrPrincipal.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
