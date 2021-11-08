package com.example.criadorcores

import RGB
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    private var RGB: RGB = RGB()
    lateinit var VerRGB: View
    lateinit var TextoRGB: TextView

    lateinit var BarraVermelha: SeekBar
    lateinit var ValorVermelho: TextView
    lateinit var BarraVerde: SeekBar
    lateinit var ValorVerde: TextView
    lateinit var BarraAzul: SeekBar
    lateinit var ValorAzul: TextView

    lateinit var BotãoSalvar: Button
    lateinit var BotãoCancelar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        RGB = RGB()

        VerRGB = findViewById(R.id.Tela)
        VerRGB.setBackgroundColor( RGB.toInt() )

        TextoRGB = findViewById(R.id.textColor)
        TextoRGB.text = RGB.toHex();
        TextoRGB.setTextColor( RGB.toIntReverse() )

        BarraVermelha = findViewById(R.id.BarraVermelha)
        BarraVermelha.setOnSeekBarChangeListener( OnChange() )

        BarraVerde = findViewById(R.id.BarraVerde)
        BarraVerde.setOnSeekBarChangeListener( OnChange() )

        BarraAzul = findViewById(R.id.BarraAzul)
        BarraAzul.setOnSeekBarChangeListener( OnChange() )

        ValorVermelho = findViewById(R.id.ValorVermelho)
        ValorVerde = findViewById(R.id.ValorVerde)
        ValorAzul = findViewById(R.id.ValorAzul)

        BotãoSalvar = findViewById(R.id.BotãoSalvar)
        BotãoSalvar.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("COLOR", RGB.toHex() );
            }

            if(intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }

        BotãoCancelar = findViewById(R.id.BotãoCancelar)
        BotãoCancelar.setOnClickListener{
            this.finish()
        }
    }

    inner class OnChange:SeekBar.OnSeekBarChangeListener {

        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

            RGB.setRed(BarraVermelha.progress)
            RGB.setGreen(BarraVerde.progress)
            RGB.setBlue(BarraAzul.progress)

            ValorVermelho.text = BarraVermelha.progress.toString()
            ValorVerde.text = BarraVerde.progress.toString()
            ValorAzul.text = BarraAzul.progress.toString()

            VerRGB.setBackgroundColor( RGB.toInt() )
            TextoRGB.setText( RGB.toHex() )
            TextoRGB.setTextColor( RGB.toIntReverse() )
        }

        override fun onStartTrackingTouch(seekBar: SeekBar?) {}

        override fun onStopTrackingTouch(seekBar: SeekBar?) {}
    }

}