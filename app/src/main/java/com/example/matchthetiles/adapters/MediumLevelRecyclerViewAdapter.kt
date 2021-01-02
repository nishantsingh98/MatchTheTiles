package com.example.matchthetiles.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.matchthetiles.R

class MediumLevelRecyclerViewAdapter(
        private var easyNumbersToFill: MutableList<Int>,
        private val listener: OnItemClickListener
) : RecyclerView.Adapter<MediumLevelRecyclerViewAdapter.ViewHolder>() {
    var lastCardPicked: Int? = null
    var currentCardPicked: Int? = null
    var lastClickPosition: Int? = null

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val textViewMediumItem: TextView = itemView.findViewById(R.id.textView_medium_item)

        init {
            itemView.setOnClickListener {
                onClick(itemView)
            }
        }

        override fun onClick(v: View?) {
            val currentPosition = adapterPosition
            currentCardPicked = Integer.parseInt(textViewMediumItem.text.toString())

            //just to make sure that the position exists
            if (adapterPosition != RecyclerView.NO_POSITION)
                listener.onItemClick(adapterPosition)
            else
                Toast.makeText(itemView.context, "position may be null pls wait", Toast.LENGTH_SHORT).show()

            checkWithLastClick(currentPosition)
        }

        //main logic for the game
        private fun checkWithLastClick(currentClickPosition: Int) {
            if (lastClickPosition == null) {
                lastClickPosition = currentClickPosition
                lastCardPicked = easyNumbersToFill[lastClickPosition!!]
            } else if (lastClickPosition != currentClickPosition) {
                if (lastCardPicked == currentCardPicked) {
                    textViewMediumItem.visibility = View.VISIBLE
                    lastCardPicked = null
                    lastClickPosition = null
                } else {
                    lastCardPicked = currentCardPicked
                    lastClickPosition = currentClickPosition
                }
            } else if (lastClickPosition == currentClickPosition) {
                lastClickPosition = currentClickPosition
                Toast.makeText(itemView.context, "NO not allowed ", Toast.LENGTH_SHORT).show()
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textViewMediumItem.text = easyNumbersToFill[position].toString()

        val delayMillis = 10000L
        val delayedTextView: View = holder.textViewMediumItem // your view
        delayedTextView.postDelayed({ delayedTextView.visibility = View.INVISIBLE }, delayMillis)
    }

    override fun getItemCount(): Int {
        return easyNumbersToFill.size
    }
}