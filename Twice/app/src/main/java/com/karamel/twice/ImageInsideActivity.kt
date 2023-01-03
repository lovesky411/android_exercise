package com.karamel.twice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class ImageInsideActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_inside)

        val getData = intent.getStringExtra("data")

        val memberImage = findViewById<ImageView>(R.id.memberImageArea)

        if(getData == "1"){
            memberImage.setImageResource(R.drawable.image_1)
        }

        if(getData == "2"){
            memberImage.setImageResource(R.drawable.image_3)
        }

        if(getData == "3"){
            memberImage.setImageResource(R.drawable.image_5)
        }
    }
}