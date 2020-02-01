package com.filippoengidashet.hybridrecyclerlistspike

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.filippoengidashet.hybridrecyclerlistspike.adapter.ItemsAdapter
import com.filippoengidashet.hybridrecyclerlistspike.mapper.ListMapper
import com.filippoengidashet.hybridrecyclerlistspike.model.Constants

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = ListMapper().mapItems(Constants.RESPONSE)
        val itemsAdapter = ItemsAdapter(items)

        findViewById<RecyclerView>(R.id.itemList).apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = itemsAdapter
        }
    }
}
