package br.com.mobile.alunosemgrupo

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class  FinalResultActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_result)
        val username = intent.getStringExtra(Constants.user_name)
        val tvName = findViewById<TextView>(R.id.tv_name)
        val tvScore = findViewById<TextView>(R.id.tv_score)
        val btnFinalizar = findViewById<Button>(R.id.btn_finalizar)
        tvName.text = username

        val totalQuestions = intent.getIntExtra(Constants.total_questions,0)
        val correctAnswers = intent.getIntExtra(Constants.correct_answers,0)

        tvScore.text = "Voce acertou $correctAnswers de $totalQuestions"

        btnFinalizar.setOnClickListener(){
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }



    }
}