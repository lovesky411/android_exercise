package com.karamel.bts_lec

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //
        val image1 = findViewById<ImageView>(R.id.image_1)
        image1.setOnClickListener {
            Toast.makeText(this, "숑숑", Toast.LENGTH_LONG).show()

            var intent = Intent(this, Bts1Activity::class.java)
            startActivity(intent)
        }

        val image2 = findViewById<ImageView>(R.id.image_2)
        val image3 = findViewById<ImageView>(R.id.image_3)

        //




    }
}