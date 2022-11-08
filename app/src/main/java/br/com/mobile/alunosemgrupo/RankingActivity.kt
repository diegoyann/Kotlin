package br.com.mobile.alunosemgrupo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_ranking.*


class RankingActivity : AppCompatActivity() {
  private var rankings : List<RankingBuilder> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ranking)

        recycler_view_ranking.layoutManager = LinearLayoutManager(this)

        val btnRetornar = findViewById<Button>(R.id.btn_retornar)

        btnRetornar.setOnClickListener {
            startActivity(Intent(this,FinalResultActivity::class.java))
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        Thread{
            rankings = RankingService.getRanking()
            runOnUiThread{
                recycler_view_ranking.adapter = RankingAdapter(rankings)
            }
        }.start()
    }

}

