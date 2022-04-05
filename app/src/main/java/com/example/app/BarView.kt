package com.example.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BarView : AppCompatActivity() {
    private lateinit var insImage: ImageView
    private lateinit var heImage: ImageView
    private lateinit var msImage: ImageView
    private lateinit var contactsRecycler: RecyclerView

    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var adapter: UsersAdapter;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bar_view2)

        insImage = findViewById(R.id.insImage)
        heImage = findViewById(R.id.heImage)
        msImage = findViewById(R.id.msImage)
        contactsRecycler = findViewById(R.id.contactsRecycler)

        layoutManager = LinearLayoutManager(this);
        contactsRecycler.layoutManager = layoutManager
        contactsRecycler.setHasFixedSize(true)

        adapter = UsersAdapter()
        contactsRecycler.adapter = adapter
    }
}