package com.example.myapplication.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.fragment.CounterFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)

        if (savedInstanceState == null) {
            val fragment = CounterFragment.newInstance()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commitNow()
        }
    }
}
