package com.example.project

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class RankAdapter(dataholder: ArrayList<User>) :
    RecyclerView.Adapter<RankAdapter.myviewholder>() {
    var dataholder: ArrayList<User>
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ):RankAdapter.myviewholder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.rank_item, parent, false)
        return myviewholder(view)
    }

    override fun onBindViewHolder(
        holder: myviewholder,
        position: Int
    ) {

    }

    override fun getItemCount(): Int {
        return 10
    }

    inner class myviewholder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var img: ImageView
        var Name: TextView
        var Score: TextView

        init {
            img = itemView.findViewById(R.id.img1)
            Name = itemView.findViewById(R.id.userName)
            Score = itemView.findViewById(R.id.userScore)
        }
    }

    init {
        this.dataholder = dataholder
    }
}