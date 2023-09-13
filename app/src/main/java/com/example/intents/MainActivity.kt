package com.example.intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import com.example.intents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var amb: ActivityMainBinding

    private lateinit var parl: ActivityResultLauncher<Intent>

    companion object {
        const val PARAMETRO_EXTRA = "PARAMETRO_EXTRA"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        amb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(amb.root)
        supportActionBar?.subtitle = "MainActivity"

        parl =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result?.resultCode == RESULT_OK) {
                    result.data?.getStringExtra(PARAMETRO_EXTRA)?.let { parametro ->
                        amb.parametroTv.text = parametro
                    }
                }
            }

        amb.entrarParametroBt.setOnClickListener {
            val parametroIntent = Intent("PARAMETRO_ACTIVITY_ACTION")
            parametroIntent.putExtra(PARAMETRO_EXTRA, amb.parametroTv.text.toString())

            parl.launch(parametroIntent)
        }
    }


}