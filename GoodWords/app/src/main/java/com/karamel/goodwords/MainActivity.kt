package com.karamel.goodwords

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.karamel.goodwords.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sentenceList = mutableListOf<String>()

        sentenceList.add("명언 간지1")
        sentenceList.add("명언 간지2")
        sentenceList.add("명언 간지3")
        sentenceList.add("명언 간지4")
        sentenceList.add("명언 간지5")
        sentenceList.add("명언 간지6")

        sentenceList.random()



        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.showAllSentenceBtn.setOnClickListener {

            val intent = Intent(this, SentenceActivity::class.java)
            startActivity(intent)
        }

        binding.goodWordTextArea.setText(sentenceList.random())
    }
}