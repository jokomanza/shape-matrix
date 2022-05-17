package com.joko.shapematrix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val view: DrawView = findViewById(R.id.photo_view)

        view.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.background, resources.newTheme()))
    }
}