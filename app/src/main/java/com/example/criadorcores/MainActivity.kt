package com.example.criadorcores

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var VerCor : View
    private lateinit var Texto : TextView
    private lateinit var Botão : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        VerCor = findViewById(R.id.VerRGB)
        Texto = findViewById(R.id.Cor)
        Botão = findViewById(R.id.Botão)

        Botão.setOnClickListener {
            val intent = Intent( this, SecondActivity::class.java )

            if(intent.resolveActivity(packageManager) != null) {
                startActivity(intent);
            }
        }

        if(intent !== null) {
            val color = intent.getStringExtra("COLOR")
            if(color != null) {
                Texto.text = color
                VerCor.setBackgroundColor( Color.parseColor(color) )
            }
        }
    }
}