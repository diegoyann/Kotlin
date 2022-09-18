@file:Suppress("DEPRECATION")

package br.com.mobile.alunosemgrupo


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.SYSTEM_UI_FLAG_FULLSCREEN
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility = SYSTEM_UI_FLAG_FULLSCREEN

        val etText = findViewById<EditText>(R.id.et_name)
        val btnStart = findViewById<Button>(R.id.btn_start)
        btnStart.setOnClickListener{
            if(etText.text.toString().isEmpty()){
                Toast.makeText(this,"Insira o Nome",Toast.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent(this,QuestionsActivity ::class.java )
                intent.putExtra(Constants.user_name, etText.text.toString())
                startActivity(intent)
                finish()
            }
        }

      }
    }
