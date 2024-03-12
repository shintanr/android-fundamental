package com.shinta.astroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvStars: RecyclerView
    private val list = ArrayList<Star> ()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvStars = findViewById(R.id.rv_stars)
        rvStars.setHasFixedSize(true)

        list.addAll(getListStars())
        showRecyclerList()
    }

    private fun getListStars(): ArrayList<Star> {
        val dataName = resources.getStringArray(R.array.star_name)
        val dataDescription = resources.getStringArray(R.array.star_description)
        val dataPhoto = resources.obtainTypedArray(R.array.star_photo)
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