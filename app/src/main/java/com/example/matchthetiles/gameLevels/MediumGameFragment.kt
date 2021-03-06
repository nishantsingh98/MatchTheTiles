package com.example.matchthetiles.gameLevels

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.matchthetiles.R
import com.example.matchthetiles.RecyclerViewAdapter

class MediumGameFragment : Fragment(), RecyclerViewAdapter.OnItemClickListener {
    private lateinit var navController: NavController
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_medium_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navController = Navigation.findNavController(view)

        val easyGameRecyclerView = view.findViewById<RecyclerView>(R.id.mediumGame_recycler_view)
        val playAgainButton = view.findViewById<Button>(R.id.button_medium_play_again)
        val timerTextView = view.findViewById<TextView>(R.id.textView_medium_timer)

        startTimer(timerTextView)

        startGame(easyGameRecyclerView)

        playAgainButton.setOnClickListener {
            startTimer(timerTextView)
            startGame(easyGameRecyclerView)
        }
    }

    private fun startGame(easyGameRecyclerView: RecyclerView) {
        val noOfColumns = 4
        val numbers = mutableListOf(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8)
        numbers.shuffle()
        easyGameRecyclerView.layoutManager = GridLayoutManager(this.context, noOfColumns)
        easyGameRecyclerView.adapter = RecyclerViewAdapter(numbers, this)
    }

    private fun startTimer(timerTextView: TextView) {
        var counter = 10
        timerTextView.visibility = View.VISIBLE
        object : CountDownTimer(10000, 1001) {
            override fun onTick(millisUntilFinished: Long) {
                val str = "game starts in $counter"
                timerTextView.text = str
                counter--
            }

            override fun onFinish() {
                timerTextView.visibility = View.INVISIBLE
            }
        }.start()
    }

    override fun onItemClick(position: Int) {

    }
}