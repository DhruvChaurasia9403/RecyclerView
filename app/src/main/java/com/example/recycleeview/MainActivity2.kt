package com.example.recycleeview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.imageview.ShapeableImageView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        supportActionBar?.hide()
        val head = intent.getStringExtra("heading")
        val des = intent.getStringExtra("description")
        val image = intent.getIntExtra("image",0)
        val imagema2 = findViewById<ShapeableImageView>(R.id.imageMA2)
        val headingma2 = findViewById<TextView>(R.id.headingMA2)
        val descriptionma2 = findViewById<TextView>(R.id.descriptionMA2)
        imagema2.setImageResource(image)
        headingma2.text = head
        descriptionma2.text = des

    }
}