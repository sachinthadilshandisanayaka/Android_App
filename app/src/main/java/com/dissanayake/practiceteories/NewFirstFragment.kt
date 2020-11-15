package com.dissanayake.practiceteories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.activity_a_second.view.*
import kotlinx.android.synthetic.main.fragment_nav_second.view.*

class NewFirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_new_first, container, false)

        view.textView1.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_newFirstFragment_to_navSecondFragment)
        }

        return view
    }
}