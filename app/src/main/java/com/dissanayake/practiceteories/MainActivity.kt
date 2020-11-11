package com.dissanayake.practiceteories

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.firstFrameLayout, firstFragment)
            commit()
        }
        btnFragmentOne.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.firstFrameLayout, firstFragment)
                addToBackStack(null)
                commit()
            }
        }
        btnTwo.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.firstFrameLayout, secondFragment)
                addToBackStack(null)
                commit()
            }
        }
    }
}