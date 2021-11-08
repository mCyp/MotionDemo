package com.wj.motiondemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.ImageView
import androidx.constraintlayout.helper.widget.Carousel

class CarMotionActivity : AppCompatActivity() {

    var images = intArrayOf(
        R.drawable.car1,
        R.drawable.car3,
        R.drawable.car4,
        R.drawable.car2
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getSupportActionBar()?.hide()
        setContentView(R.layout.activity_car_motion)

        val carsoul = findViewById<Carousel>(R.id.carousel)
        carsoul.setAdapter(object : Carousel.Adapter {
            override fun count(): Int {
                return 4
            }

            override fun populate(view: View?, index: Int) {
                if(view is ImageView){
                    view.setImageResource(images[index])
                }
            }

            override fun onNewItem(index: Int) {
                // called when an item is set
            }
        })
    }
}