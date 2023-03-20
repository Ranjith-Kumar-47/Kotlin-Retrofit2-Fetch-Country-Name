package com.example.countrynames

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MainActivity : AppCompatActivity() {
    var recyclerView: RecyclerView? = null
    var countryNameAdapter: CountryNameAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val progressBar:ProgressBar = findViewById(R.id.progressBar)
        progressBar.visibility = View.VISIBLE
        val viewModelProvider: MainActivityViewModel =
            ViewModelProvider(this)[MainActivityViewModel::class.java]
        viewModelProvider.apiCall()
        viewModelProvider.getLiveDataObserver().observe(this, Observer {
            addDataToRecyclerView(it.data,progressBar)
        })
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView!!.layoutManager = LinearLayoutManager(this)
    }

    private fun addDataToRecyclerView(data: List<Data>, progressBar: ProgressBar) {
        countryNameAdapter = CountryNameAdapter(data,progressBar,this)
        recyclerView?.adapter = countryNameAdapter

    }
}