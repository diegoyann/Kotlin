package br.com.mobile.alunosemgrupo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_ranking.*
import android.content.Context
import br.com.mobile.alunosemgrupo.RankingService.saveOffline


class RankingActivity : AppCompatActivity() {
    private var place = listOf<RankingBuilder>()
    private var REQUEST_CADASTRO = 1
    private var REQUEST_REMOVE= 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ranking)

        recycler_view_ranking.adapter = RankingAdapter(realRanking())
        recycler_view_ranking.layoutManager = LinearLayoutManager(this)

        val btnRetornar = findViewById<Button>(R.id.btn_retornar)

        btnRetornar.setOnClickListener {
            startActivity(Intent(this,FinalResultActivity::class.java))
            finish()
        }
    }

}

