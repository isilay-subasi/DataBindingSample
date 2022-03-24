package com.example.databindingsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.databindingsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)

        //Düzen yöneticisi - layoutManager
        //LinearLayoutManager - GridLayoutManager - StaggeredGridLayoutManager
        binding.recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

        val playersList = mutableListOf<Player>()
        playersList.add(Player("Cristiano Ronaldo","Juventus","Portugal"))
        playersList.add(Player("Thiago Silva","PSG","Brazil"))
        playersList.add(Player("Sergio Ramos","Real Madrid","Spain"))

        val adapter = PlayerAdapter(this, playersList)
        binding.recyclerView.adapter = adapter
    }
}