package com.example.profileapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val profilePic = findViewById<ImageView>(R.id.profilePic)
        val experiencesLayout = findViewById<LinearLayout>(R.id.experiences)

        val experiences = listOf(
            "Projeto Integrado 1",
            "Projeto Integrado 2",
            "Monitor do curso Aprendendo a Programar com Games"
        )

        for(experience in experiences){
            val textView = TextView(this)
            textView.text = experience
            textView.textSize = 16f
            experiencesLayout.addView(textView)
        }
        profilePic.setOnClickListener{Toast.makeText(this, "Image of Ellie form the last of us", Toast.LENGTH_SHORT).show()}
    }
}