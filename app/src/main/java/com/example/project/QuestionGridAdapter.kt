package com.example.project

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class QuestionGridAdapter(var numofQues:Int): BaseAdapter() {


    override fun getCount(): Int {
      return  10;
    }

    override fun getItem(position: Int): Any {
        TODO("Not yet implemented")
    }

    override fun getItemId(position: Int): Long {
        TODO("Not yet implemented")
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view:View
        if (convertView==null){
                view=LayoutInflater.from(parent!!.context).inflate(R.layout.quest_grid_item,parent,false)
        }else{
            view=convertView
        }
        val quesTv:TextView = view.findViewById(R.id.ques_num)
        quesTv.setText(position+1)

        return view
    }
}