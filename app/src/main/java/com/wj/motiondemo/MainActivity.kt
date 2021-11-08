package com.wj.motiondemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<TextView>(R.id.tv1).setOnClickListener {
            val intent = Intent(this, AnimeActivity::class.java)
            startActivity(intent)
        }

        findViewById<TextView>(R.id.tv2).setOnClickListener {
            val intent = Intent(this, CarMotionActivity::class.java)
            startActivity(intent)
        }

        findViewById<TextView>(R.id.tv3).setOnClickListener {
            val intent = Intent(this, CardMotionActivity::class.java)
            startActivity(intent)
        }

        findViewById<TextView>(R.id.tv4).setOnClickListener {
            val intent = Intent(this, AnimeActivity::class.java)
            startActivity(intent)
        }
    }
}