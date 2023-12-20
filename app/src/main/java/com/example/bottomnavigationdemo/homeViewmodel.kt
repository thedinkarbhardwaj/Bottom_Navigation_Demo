package com.example.bottomnavigationdemo

import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class homeViewmodel:ViewModel() {

    lateinit var homefrag: homefragment

    private val dummyDataList = mutableListOf<dummyData>()
    private lateinit var adapter: HomeAdpt
    var firsttime = true

    fun init(activity: homefragment) {
        homefrag = activity

        Toast.makeText(homefrag.requireContext(), "init", Toast.LENGTH_LONG).show()
        if (dummyDataList.isEmpty()) {
            for (i in 1..270) {
                dummyDataList.add(dummyData("Item $i",R.drawable.ic_launcher_background))
            }
        }
        setrecyclerview()

        if (dummyDataList.isEmpty()) {
            // setrecyclerview()
        }

    }

    private fun setrecyclerview() {

        // var recyclerView = causefragment.recyclerView
        var recyclerView = homefrag.binding.recyclerview
        //  recyclerView.layoutManager = LinearLayoutManager(causefragment.requireContext())
        recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        // Create dummy data


        // Create and set the adapter
        adapter = HomeAdpt(homefrag,dummyDataList)
        recyclerView.adapter = adapter

    }
}