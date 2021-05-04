package com.example.project

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class ChapterAdapter(var context: Context, chapterModels: ArrayList<chapterModel>) :
    RecyclerView.Adapter<ChapterAdapter.ChapterViewHolder>() {
    var chapterModels: ArrayList<chapterModel>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChapterViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_chapter, null)
        return ChapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChapterViewHolder, position: Int) {

        val currentItem= chapterModels[position]
        holder.textView.text=currentItem.chapterName


        holder.itemView.setOnClickListener {
            val intent = Intent(context, QcmActivity::class.java)
            intent.putExtra("chapterId", currentItem.chapterId)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return chapterModels.size
    }

    inner class ChapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var textView: TextView

        init {

            textView = itemView.findViewById(R.id.chapter)
        }
    }

    init {
        this.chapterModels = chapterModels
    }
}
