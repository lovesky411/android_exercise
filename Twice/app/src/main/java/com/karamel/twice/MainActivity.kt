package com.karamel.twice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn1 = findViewById<ImageView>(R.id.member_1)
        btn1.setOnClickListener {
            val intent = Intent(this, ImageInsideActivity::class.java)
            intent.putExtra("data", 1)
            startActivity(intent)
        }

        val btn2 = findViewById<ImageView>(R.id.member_2)
        btn2.setOnClickListener {
            val intent = Intent(this, ImageInsideActivity::class.java)
            intent.putExtra("data", 2)
            startActivity(intent)
        }

        val btn3 = findViewById<ImageView>(R.id.member_3)
        btn3.setOnClickListener {
            val intent = Intent(this, ImageInsideActivity::class.java)
            intent.putExtra("data", 3)
            startActivity(intent)
        }
    }
}