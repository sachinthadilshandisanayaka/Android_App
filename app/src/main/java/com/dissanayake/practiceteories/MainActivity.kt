package com.dissanayake.practiceteories

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Button
import android.widget.Toast

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
