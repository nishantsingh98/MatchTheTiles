package com.example.matchthetiles.gameLevels

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.matchthetiles.R

class EasyGameFragment : Fragment(), View.OnClickListener {
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
        val easy1 = view.findViewById<Button>(R.id.easy_1)
        val easy2 = view.findViewById<Button>(R.id.easy_2)
        val easy3 = view.findViewById<Button>(R.id.easy_3)
        val easy4 = view.findViewById<Button>(R.id.easy_4)

        easy1.setOnClickListener(this)
        easy2.setOnClickListener(this)
        easy3.setOnClickListener(this)
        easy4.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.easy_1 -> Toast.makeText(context, "button ${R.id.easy_1}", Toast.LENGTH_SHORT)
                .show()
            R.id.easy_2 -> Toast.makeText(context, "button ${R.id.easy_2}", Toast.LENGTH_SHORT)
                .show()
            R.id.easy_3 -> Toast.makeText(context, "button ${R.id.easy_3}", Toast.LENGTH_SHORT)
                .show()
            R.id.easy_4 -> Toast.makeText(context, "button ${R.id.easy_4}", Toast.LENGTH_SHORT)
                .show()
        }
    }
}