package com.shinta.myastro

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private lateinit var rvStars: RecyclerView
    private val list = ArrayList<Star>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvStars = findViewById(R.id.rv_star)
        rvStars.setHasFixedSize(true)

        list.addAll(getListStars())
        showRecyclerList()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_about, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.about_page -> {
                startActivity(Intent(this, AboutActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun getListStars(): ArrayList<Star> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listStar = ArrayList<Star>()
        for (i in dataName.indices) {
            val star = Star(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listStar.add(star)
        }
        return listStar
    }

    private fun showRecyclerList() {
        rvStars.layoutManager = LinearLayoutManager(this)
        val listStarAdapter = ListStarAdapter(list)
        rvStars.adapter = listStarAdapter
    }
}