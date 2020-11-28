package com.dissanayake.practiceteories.activities

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.dissanayake.practiceteories.fragments.FirstFragment
import com.dissanayake.practiceteories.R
import com.dissanayake.practiceteories.fragments.SecondFragment
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

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
        // second activity
        val coordinatorId = findViewById<CoordinatorLayout>(R.id.coordinatorLayout)
        floatingActionButton2.setOnClickListener {
            Snackbar.make(coordinatorId, "Show Toast message", Snackbar.LENGTH_LONG)
                    .setAction("show now"){
                        // move to second activity
                        val navToSecondActivity = Intent(this, ASecondActivity::class.java)
                        startActivity(navToSecondActivity)
                    }
                    .setBackgroundTint(Color.parseColor("#5D6D7E"))
                    .setAnimationMode(BaseTransientBottomBar.ANIMATION_MODE_FADE)
                    .show()
        }

    }


    // this method must be public
    public fun onSearchClick(menuItem: MenuItem) {
    showToast("Search")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_one, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.item2 -> {
                showToast("item 2")
                return true
            }
            R.id.item3 -> {
                showToast("item 3")
                return true
            }
            R.id.subItem1 -> {
                showToast("item 4")
                return true
            }
            R.id.subItem2 -> {
                showToast("item 5")
                return true
            }
            R.id.subItem3 -> {
                showToast("item 6")
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }
    public fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}
