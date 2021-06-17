package com.example.customrecyclerview_project.models

import android.media.Image
import android.util.Log

class UserModel(var userPhoto: String,
                var userName: String,
                var userEmail: String? = null,
                var userPhone: String?= null ) {
    val TAG: String = "logMsg"

    init {
        Log.d(TAG, "userModel - () init")
    }
}