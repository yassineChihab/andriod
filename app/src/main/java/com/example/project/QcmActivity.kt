package com.example.project

import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class QcmActivity : AppCompatActivity() {

    var db: DatabaseHelper? = null
    private lateinit var questionList: ArrayList<Question>
    private var adapterQst: RecyclerView.Adapter<customAdapterQcm.ViewHolder>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qcm)
        listQuestion()








    }
    fun listQuestion() {

        // DB
        db = DatabaseHelper(this)
        val id=intent.getIntExtra("chapter",1)

        // Fetch categories
        var questionCursor: Cursor? = db!!.rawQuery("SELECT question_id , question_phrase ,id_chapter FROM question WHERE id_chapter="+id+"")
        var questionSize: Int = questionCursor!!.count
        Log.d("listQuestion()", "questionSize=" + questionSize)

        // Add a list of chpater
        questionList = ArrayList<Question>()
        while (questionCursor.moveToNext()) {
            val qstId = questionCursor.getInt(0)
            val qstText = questionCursor.getString(1)
            val chapterId=questionCursor.getInt(2)
            Log.d("listQuestion()", "qstId=" + qstId + " qstText=" + qstText +"chapterId" +chapterId)
            questionList.add(Question(qstId,qstText,chapterId))

        }

        // Add to list
        val recy = findViewById<RecyclerView>(R.id.recyqcm)
        adapterQst=customAdapterQcm(questionList)
        recy.adapter = adapterQst
        recy.layoutManager = LinearLayoutManager(this)
        recy.setHasFixedSize(true)

    } // listCategories
}