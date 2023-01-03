package com.karamel.dice_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.karamel.dice_app.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val diceImage1 = binding.dice1

        val diceImage2 = binding.dice2

        binding.diceStartBtn.setOnClickListener{

            val number1 = Random.nextInt(1, 6)

            val number2 = Random.nextInt(1, 6)






            diceImage1.setImageResource(R.drawable.dice_2)

            diceImage2.setImageResource(R.drawable.dice_3)

        }

    }

}