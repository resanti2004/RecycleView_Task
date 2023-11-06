package com.example.recycleview_task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        val headingProduct : TextView = findViewById(R.id.heading)
        val mainProduct : TextView = findViewById(R.id.product)
        val imageProduct : ImageView = findViewById(R.id.image_heading)

        val bundle : Bundle?= intent.extras
    }
}