package com.example.project

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter( val list: ArrayList<IdTitleChapter>,private  val onchapterClicklistener: onChapter_clickListener) :
        RecyclerView.Adapter<CustomAdapter.ViewHolder>() {


    /**            radio1=view.findViewById(R.id.radio1)

     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView

        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.chapterId)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.single_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val currentItem = list[position]
        viewHolder.textView.text=currentItem.title

        viewHolder.textView.setOnClickListener{
            onchapterClicklistener.onChapterClickListenner(position)        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount():Int{
        return list.size

    }

}