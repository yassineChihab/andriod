package com.example.project

import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(),onChapter_clickListener {

    // Class variables
    var db: DatabaseHelper? = null
    private lateinit var chapterList: ArrayList<IdTitleChapter>


    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapterChapter: RecyclerView.Adapter<CustomAdapter.ViewHolder>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listChapter()
        /* layoutManager=LinearLayoutManager(this)
        val recy=findViewById<RecyclerView>(R.id.chapter)
        recy.layoutManager=layoutManager

        adapter=CustomAdapter()

        recy.adapter=adapter*/


    }

    fun listChapter() {

        // DB
        db = DatabaseHelper(this)

        // Fetch categories
        var ChapterCursor: Cursor? = db!!.rawQuery("SELECT chapter_id, chapter_name FROM chapter")
        var chaptersSize: Int = ChapterCursor!!.count
        Log.d("listChapter()", "chapterSize=" + chaptersSize)

        // Add a list of chpater
        chapterList = ArrayList<IdTitleChapter>()
        while (ChapterCursor.moveToNext()) {
            val chapterId = ChapterCursor.getInt(0)
            val chapterName = ChapterCursor.getString(1)
            Log.d("listChapter()", "ChapterId=" + chapterId + " ChapterNome=" + chapterName)
            chapterList.add(IdTitleChapter(chapterId, chapterName))

        }

        // Add to list
        val recy = findViewById<RecyclerView>(R.id.chapter)
        adapterChapter=CustomAdapter(chapterList,this)
        recy.adapter = adapterChapter
        recy.layoutManager = LinearLayoutManager(this)
        recy.setHasFixedSize(true)

    } // listCategories


    /*- List on click ---------------------------------------------------------------------------- */
    fun listOnClick(itemID: Int) {
        // TODO: How can I get the program to go here?
    } // listOnClick

    override fun onChapterClickListenner(postion: Int) {
            val intent=Intent(this,QcmActivity::class.java)
            intent.putExtra("chapter",chapterList[postion].title)
            startActivity(intent)
    }
}


