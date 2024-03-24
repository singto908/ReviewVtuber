package com.example.seller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.FirebaseDatabase

lateinit var recyclerView: RecyclerView
lateinit var mainAdapter: MainAdapter
lateinit var floatingActionbutton: FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rv)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val options = FirebaseRecyclerOptions.Builder<MainModel>()
            .setQuery(FirebaseDatabase.getInstance().reference.child("Sniper"), MainModel::class.java)
            .build()

        mainAdapter = MainAdapter(options);
        recyclerView.adapter = mainAdapter

        val floatingActionButton :FloatingActionButton = findViewById(R.id.fbt)
        floatingActionButton.setOnClickListener{
            val intent = Intent(this, AddActivity::class.java);
            startActivity(intent)
        }
    }

    @Override
    override fun onStart() {
        super.onStart();
        mainAdapter.startListening();
    }

    @Override
    override fun onStop() {
        super.onStop();
        mainAdapter.stopListening();
    }
}