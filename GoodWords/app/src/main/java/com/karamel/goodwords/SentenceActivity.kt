package com.karamel.goodwords

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class SentenceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sentence)





        val sentenceList = mutableListOf<String>()

        sentenceList.add("명언 간지1")
        sentenceList.add("명언 간지2")
        sentenceList.add("명언 간지3")
        sentenceList.add("명언 간지4")
        sentenceList.add("명언 간지5")
        sentenceList.add("명언 간지6")

        sentenceList.random()

        val sadapter = ListViewAdapter(sentenceList)

        val listView = findViewById<ListView>(R.id.sentenceListView)

        listView.adapter = sadapter


    }
}