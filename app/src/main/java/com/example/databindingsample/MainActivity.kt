package com.example.databindingsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.databindingsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)

        //Düzen yöneticisi - layoutManager
        //LinearLayoutManager - GridLayoutManager - StaggeredGridLayoutManager
       // binding.recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        binding.recyclerView.layoutManager = GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false)


       // val playersList = mutableListOf<Player>()

        //playersList.add(Player(R.drawable.snapchat,"Snapchat"))


        val adapter = PlayerAdapter(this, DummyData.getDummyData() as ArrayList<Player>)
        binding.recyclerView.adapter = adapter
    }
}