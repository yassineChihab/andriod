package com.example.project

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class customAdapterQcm( val list: ArrayList<Question>): RecyclerView.Adapter<customAdapterQcm.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val qst: TextView
        val radio1:RadioButton
        val radio2:RadioButton
        val radio3:RadioButton
        val radio4:RadioButton

        init {
            // Define click listener for the ViewHolder's View.
            qst = view.findViewById(R.id.question)
            radio1=view.findViewById(R.id.radio1)
            radio2=view.findViewById(R.id.radio2)
            radio3=view.findViewById(R.id.radio3)
            radio4=view.findViewById(R.id.radio4)

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_qst, parent, false)

        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        val currentItem=list[position]
        holder.qst.text=currentItem.content
    }

    override fun getItemCount(): Int {
        return list.size

    }



}