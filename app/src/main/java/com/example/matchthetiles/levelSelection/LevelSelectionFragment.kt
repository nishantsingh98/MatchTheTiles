package com.example.matchthetiles.levelSelection

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.matchthetiles.R

class LevelSelectionFragment : Fragment(), View.OnClickListener {
    private lateinit var navController: NavController
     override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_level_selection, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navController = Navigation.findNavController(view)

        view.findViewById<Button>(R.id.button_easy).setOnClickListener(this)
        view.findViewById<Button>(R.id.button_medium).setOnClickListener(this)
        view.findViewById<Button>(R.id.button_hard).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.button_easy -> navController.navigate(R.id.action_levelSelectionFragment_to_easy_gameFragment)
            R.id.button_medium -> navController.navigate(R.id.action_levelSelectionFragment_to_medium_gameFragment)
            R.id.button_hard -> navController.navigate(R.id.action_levelSelectionFragment_to_hard_GameFragment)
        }
    }
}