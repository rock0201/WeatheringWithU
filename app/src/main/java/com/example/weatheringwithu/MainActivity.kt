package com.example.weatheringwithu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.weatheringwithu.ui.place.PlaceViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val viewModel by lazy { ViewModelProviders.of(this).get(PlaceViewModel::class.java) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.searchPlace("北京")
        viewModel.placeLiveData.observe(this, Observer {result->
            val places = result.getOrNull()
            textView.text = places.toString()

        })
    }
}
