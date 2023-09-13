package com.example.intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var amb: ActivityMainBinding

    // Em kotlin, o companion object funciona como um singleton. Não é necessário definir tipos
    // pois ele só será utilizado aqui.
    companion object {
        const val PARAMETRO_EXTRA = "PARAMETRO_EXTRA"
        const val PARAMETRO_REQUEST_CODE = 0 // este parâmetro tem que ser passado para a tela que
        // irá abrir, e depois a tela que foi aberta devolverá à anterior, como um token.

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        amb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(amb.root)
        supportActionBar?.subtitle = "MainActivity"

        amb.entrarParametroBt.setOnClickListener {
            val parametroIntent = Intent(this, ParametroActivity::class.java)
            //  val parametrosBundle = Bundle()
            //  parametrosBundle.putString(PARAMETRO_EXTRA, amb.parametroTv.text.toString())

            // Agora, vamos usar o Bundle que a Intent por padrão já possui:
            parametroIntent.putExtra(PARAMETRO_EXTRA, amb.parametroTv.text.toString())

            startActivityForResult(parametroIntent, PARAMETRO_REQUEST_CODE)
        }
    }


}