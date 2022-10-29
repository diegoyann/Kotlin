@file:Suppress("DEPRECATION")

package br.com.mobile.alunosemgrupo


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.SYSTEM_UI_FLAG_FULLSCREEN
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : AppCompatActivity () {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24)

        val toggle = ActionBarDrawerToggle(this,mainLayout,toolbar,R.string.open,R.string.close)
        val etText = findViewById<EditText>(R.id.et_name)
        val btnStart = findViewById<Button>(R.id.btn_start)
        toggle.isDrawerIndicatorEnabled = true
        mainLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        window.decorView.systemUiVisibility = SYSTEM_UI_FLAG_FULLSCREEN

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

    override fun onResume() {
        super.onResume()
       /* openRanking()*/
    }

   /* fun openRanking() {
        if (intent.hasExtra("rankingID"))
    }*/

}
