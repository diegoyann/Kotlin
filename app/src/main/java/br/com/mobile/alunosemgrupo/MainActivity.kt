@file:Suppress("DEPRECATION")

package br.com.mobile.alunosemgrupo


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View.SYSTEM_UI_FLAG_FULLSCREEN
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : AppCompatActivity (), NavigationView.OnNavigationItemSelectedListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24)

        val toggle = ActionBarDrawerToggle(this,mainLayout,toolbar,R.string.open,R.string.close)
        val etText = findViewById<EditText>(R.id.et_name)
        val btnStart = findViewById<Button>(R.id.btn_start)
        val menuLateral = findViewById<NavigationView>(R.id.nav_menu)
        toggle.isDrawerIndicatorEnabled = true
        mainLayout.addDrawerListener(toggle)
        toggle.syncState()
        menuLateral.setNavigationItemSelectedListener(this)

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


    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.nav_ranking -> {
                val intent = Intent(this,RankingActivity ::class.java )
                startActivity(intent)
            }
            R.id.nav_home -> {
                val intent = Intent(this,MainActivity ::class.java )
                startActivity(intent)
            }
            R.id.nav_about -> {
                Toast.makeText(this, "Entre em contato com diegoyann19@gmail.com", Toast.LENGTH_SHORT).show()
            }
    }

        return true
    }

    }




