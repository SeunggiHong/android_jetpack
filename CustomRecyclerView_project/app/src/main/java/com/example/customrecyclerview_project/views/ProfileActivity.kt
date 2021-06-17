package com.example.customrecyclerview_project.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.customrecyclerview_project.R
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
    val TAG: String = "logMsg"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        Log.d(TAG, "ProfileActivity - onCreate() called")

         tv_profile_name.text = intent.getStringExtra("name")

        Glide.with(this)
            .load(intent.getStringExtra("pic"))
            .placeholder(R.drawable.ic_baseline_image_24)
            .into(this.iv_profile_photo)
    }
}