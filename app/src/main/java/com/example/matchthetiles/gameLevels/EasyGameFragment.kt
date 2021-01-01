package com.example.matchthetiles.gameLevels

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.matchthetiles.R
import com.example.matchthetiles.RecyclerViewAdapter

class EasyGameFragment : Fragment() {
    private lateinit var navController: NavController
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.easy_fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navController = Navigation.findNavController(view)

        val easyGameRecyclerView = view.findViewById<RecyclerView>(R.id.easyGame_recycler_view)
        val noOfColumns = 4
        val numbers = mutableListOf(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8)
        numbers.shuffle()
        easyGameRecyclerView.layoutManager = GridLayoutManager(this.context, noOfColumns)
        easyGameRecyclerView.adapter = RecyclerViewAdapter(numbers)
    }
}