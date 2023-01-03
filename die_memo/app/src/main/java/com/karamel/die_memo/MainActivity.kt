package com.karamel.die_memo

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.util.*

class MainActivity : AppCompatActivity() {

    val dataModelList = mutableListOf<DataModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = Firebase.database
        val myRef = database.getReference("myMemo")

        val listView = findViewById<ListView>(R.id.mainLV)

        val adapter_list = ListViewAdapter(dataModelList)


        listView.adapter = adapter_list

        myRef.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                dataModelList.clear()
                for(dataModel in snapshot.children){
                    Log.d("data", dataModel.toString())
                    dataModelList.add(dataModel.getValue(DataModel::class.java)!!)
                }

                adapter_list.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

        val writeButton = findViewById<ImageView>(R.id.writeBtn)
        writeButton.setOnClickListener {

            val mDialogView = LayoutInflater.from(this ).inflate(R.layout.custom_dialog, null)
            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle("운동 메모 다이얼로그")

            val mAlertDialog = mBuilder.show()

            var dateText = ""

            mAlertDialog.findViewById<Button>(R.id.dateSelectBtn)?.setOnClickListener {

                val today = GregorianCalendar()
                val year : Int = today.get(Calendar.YEAR)
                val month : Int = today.get(Calendar.MONTH)
                val date : Int = today.get(Calendar.DATE)

                val dlg = DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener{
                    override fun onDateSet(                     view: DatePicker?,                       year: Int,   month: Int,        date: Int) {

                        mAlertDialog.findViewById<Button>(R.id.dateSelectBtn)!!.setText("${year}, ${month + 1}, ${date}")

                        dateText = "${year}, ${month + 1}, ${date}"
                    }

                }, year, month, date)

                dlg.show()
            }

            val saveBtn = mAlertDialog.findViewById<Button>(R.id.saveBtn)

            saveBtn?.setOnClickListener {

                val memo = mAlertDialog.findViewById<EditText>(R.id.memoText)?.text.toString()

                val database = Firebase.database
                val myRef = database.getReference("myMemo")

                val model = DataModel(dateText, memo)

                myRef.push().setValue(model)



            }
        }
    }
}