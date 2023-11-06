package com.example.recycleview_task

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var newRecylerview : RecyclerView
    private lateinit var newArrayList: ArrayList<Product>
    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>
    lateinit var product: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageId = arrayOf(
            R.drawable.unilever,
            R.drawable.kfc,
            R.drawable.mcd,
            R.drawable.pg_logo,
            R.drawable.hp,
            R.drawable.unilever,
            R.drawable.kfc,
            R.drawable.mcd,
            R.drawable.pg_logo,
            R.drawable.hp,
        )

        heading = arrayOf(
            "Unilever",
            "KFC",
            "MCD",
            "P&G",
            "Hp",
            "Unilever",
            "KFC",
            "MCD",
            "P&G",
            "Hp"
        )

        product = arrayOf(
            getString(R.string.product_unilever),
            getString(R.string.product_kfc),
            getString(R.string.product_mcd),
            getString(R.string.product_pg),
            getString(R.string.product_hp),
            getString(R.string.product_hp),
            getString(R.string.product_hp),
            getString(R.string.product_hp),
            getString(R.string.product_hp),
            getString(R.string.product_hp)
        )

        newRecylerview = findViewById(R.id.recyclerView)
        newRecylerview.layoutManager = LinearLayoutManager(this)
        newRecylerview.setHasFixedSize(true)

        newArrayList = arrayListOf<Product>()
        getUserdata()

    }

    private fun getUserdata() {

        for(i in imageId.indices){
            val product = Product(imageId[i], heading[i])
            newArrayList.add(product)
        }

        var adapter = MyAdapter(newArrayList)
        newRecylerview.adapter = adapter
        adapter.setOnItemClickListener(object :MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                //Toast.makeText(this@MainActivity, "You clicked on item no, $position", Toast.LENGTH_SHORT).show()

                val intent = Intent(this@MainActivity, ProductActivity::class.java)
                intent.putExtra("heading", newArrayList[position].heading)
                intent.putExtra("imageId", newArrayList[position].titleImage)
                intent.putExtra("product", product[position])
                startActivity(intent)

            }
        })

    }
}