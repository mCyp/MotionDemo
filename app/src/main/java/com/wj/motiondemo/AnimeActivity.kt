package com.wj.motiondemo

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.ImageView
import androidx.constraintlayout.helper.widget.Carousel
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.request.transition.Transition
import jp.wasabeef.glide.transformations.BlurTransformation

class AnimeActivity : AppCompatActivity() {

    var images = intArrayOf(
        R.drawable.dm1,
        R.drawable.dm2,
        R.drawable.dm3,
        R.drawable.dm4,
        R.drawable.dm5
    )

    var imageDrawable = Array<Drawable?>(5) { _ ->
        null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getSupportActionBar()?.hide()
        setContentView(R.layout.activity_anime)


        val ivBackground = findViewById<ImageView>(R.id.ivBackground)
        val carsoul = findViewById<Carousel>(R.id.carousel)
        carsoul.setAdapter(object : Carousel.Adapter {
            override fun count(): Int {
                return 5
            }

            override fun populate(view: View?, index: Int) {
                Log.d("wangjie", "index: " + index)
                Log.d("wangjie", "currentIndex: " + carsoul.currentIndex)
                if (view is ImageView) {
                    view.setImageResource(images[index])
                    // val targetIndex = (carsoul.currentIndex + 2) % 5
                    val targetIndex = index
                    val drawable = imageDrawable.getOrNull(targetIndex)
                    if (drawable == null) {
                        Glide.with(this@AnimeActivity)
                            .load(images[targetIndex])
                            .apply(RequestOptions().transform(BlurTransformation(20)))
                            .into(object : SimpleTarget<Drawable>() {
                                override fun onResourceReady(
                                    resource: Drawable,
                                    transition: Transition<in Drawable>?
                                ) {
                                    ivBackground.setImageDrawable(resource)
                                    imageDrawable[targetIndex] = resource
                                }
                            })
                    } else {
                        ivBackground.setImageDrawable(drawable)
                    }
                }
            }

            override fun onNewItem(index: Int) {
                // called when an item is set
            }
        })
    }
}