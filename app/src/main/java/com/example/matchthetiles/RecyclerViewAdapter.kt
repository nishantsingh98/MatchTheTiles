package com.example.matchthetiles

import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(private var easyNumbersToFill: MutableList<Int>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewEasyItem: TextView = itemView.findViewById(R.id.textView_easy_item)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                Toast.makeText(itemView.context, "position # ${position + 1}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textViewEasyItem.text = easyNumbersToFill[position].toString()

        val delayMillis = 10000
        val handler = Handler()
        val tvRQPoint: View = holder.textViewEasyItem // your view
        tvRQPoint.postDelayed(Runnable { tvRQPoint.visibility = View.INVISIBLE }, 3000)
    }

    override fun getItemCount(): Int {
        return easyNumbersToFill.size
    }

}