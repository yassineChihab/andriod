package com.example.project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project.databinding.ActivityChapterBinding
import com.example.project.databinding.ActivityLoginBinding

class ChapterActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityChapterBinding

    private lateinit var chapterList: ArrayList<chapterModel>


    private var layoutManager: RecyclerView.LayoutManager? = null
    private var chapterAdapter: RecyclerView.Adapter<ChapterAdapter.ChapterViewHolder>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityChapterBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        layoutManager= GridLayoutManager(this,2)

        chapterList=ArrayList<chapterModel>()
        chapterList.add(chapterModel(1,"Chapitre 1"))
        chapterList.add(chapterModel(2,"Chapitre 2"))

        chapterList.add(chapterModel(3,"Chapitre 3"))

        chapterList.add(chapterModel(4,"Chapitre 4"))
        chapterList.add(chapterModel(5,"Chapitre 5"))
        chapterList.add(chapterModel(6,"Chapitre 6"))



        chapterAdapter=ChapterAdapter(this, chapterList);
        binding.chapterList.layoutManager=layoutManager
        binding.chapterList.adapter=chapterAdapter



    }
}