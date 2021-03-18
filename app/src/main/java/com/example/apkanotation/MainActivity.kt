package com.example.apkanotation

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var rvMain: RecyclerView
    lateinit var btnFloating: FloatingActionButton
    lateinit var emptyImage: ImageView
    lateinit var noData: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMain = findViewById(R.id.recyclerView)
        btnFloating = findViewById(R.id.add_button)
        emptyImage = findViewById(R.id.empty_imageview)
        noData = findViewById(R.id.no_data)




    }


}

