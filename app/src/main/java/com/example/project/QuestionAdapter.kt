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

class QuestionAdapter(var context: Context) :
    RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):QuestionViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.question_item_layout, null)
        return QuestionViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {



    }

    override fun getItemCount(): Int {
        return  10;

    }

    inner class QuestionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    }


}
