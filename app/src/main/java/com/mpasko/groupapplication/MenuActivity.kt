package com.mpasko.groupapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

    }

    fun runGame(item: MenuItem) {
        val intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
    }
    fun meetTeam(item: MenuItem) {
        val intent = Intent(this, TeamActivity::class.java)
        startActivity(intent)
    }
    fun getIdea(item: MenuItem) {
        val intent = Intent(this, IdeaActivity::class.java)
        startActivity(intent)
    }
}