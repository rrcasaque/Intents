package com.example.intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intents.databinding.ActivityParametroBinding

class ParametroActivity : AppCompatActivity() {
    private val apb by lazy {
        ActivityParametroBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(apb.root)
        supportActionBar?.subtitle = "ParametroActivity"

        val parametroRecebido: String = intent.getStringExtra(MainActivity.PARAMETRO_EXTRA) ?: ""
        apb.parametroEt.setText(parametroRecebido)

        intent.getStringExtra(MainActivity.PARAMETRO_EXTRA)?.let { parametro ->
            apb.parametroEt.setText(parametro)
        }

//        também pode ser escrito assim:
//
//        intent.getStringExtra(MainActivity.PARAMETRO_EXTRA)?.let {
//            apb.parametroEt.setText(it)
//        }
//
//        método apply:
//        intent.getStringExtra(MainActivity.PARAMETRO_EXTRA)?.apply {
//            apb.parametroEt.setText(this)
//        }

        apb.enviarParametroBt.setOnClickListener {
            val intentRetorno = Intent()
//            criando a variável aqui e não fora do método, eu poupo no desempenho; só será criada quando o método for executado
//            val parametroRetorno = apb.parametroEt.text.toString()
//            intent.putExtra(MainActivity.PARAMETRO_EXTRA, parametroRetorno)
            intent.putExtra(MainActivity.PARAMETRO_EXTRA, apb.parametroEt.text.toString())
            setResult(RESULT_OK, intentRetorno)
            // chama onPause, onStop e onDestroy:
            finish()
        }

    }
}