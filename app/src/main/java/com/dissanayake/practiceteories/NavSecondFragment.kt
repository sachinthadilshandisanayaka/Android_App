package com.dissanayake.practiceteories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_nav_second.view.*
import kotlinx.android.synthetic.main.fragment_new_first.view.*

class NavSecondFragment : Fragment() {
    // for passing arguments
    val args: NavSecondFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_nav_second, container, false)

        // get passing number
        val getPassingNumber = args.number
        // setText = text
        view.textViewForNumber.text = getPassingNumber.toString()
        view.textView2.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_navSecondFragment_to_newFirstFragment)
        }

        return view
    }
}