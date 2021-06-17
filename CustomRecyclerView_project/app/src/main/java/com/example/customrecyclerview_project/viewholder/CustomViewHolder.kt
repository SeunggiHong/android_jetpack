package com.example.customrecyclerview_project.viewholder

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.customrecyclerview_project.App
import com.example.customrecyclerview_project.R
import com.example.customrecyclerview_project.interfaces.ClickInterface
import com.example.customrecyclerview_project.models.UserModel

class CustomViewHolder(view: View, mClickInterface: ClickInterface) : RecyclerView.ViewHolder(view), View.OnClickListener {
    val TAG: String = "logMsg"

    private val userPhoto: ImageView
    private val userName: TextView
    private val userEmail: TextView
    private val userPhone: TextView
    private var mClickInterface: ClickInterface? = null

    init {
        Log.d(TAG, "CustomViewHolder init")
        userPhoto = view.findViewById(R.id.iv_user)
        userName = view.findViewById(R.id.tv_username)
        userEmail = view.findViewById(R.id.tv_usermail)
        userPhone = view.findViewById(R.id.tv_phone)

        itemView.setOnClickListener(this)
        this.mClickInterface = mClickInterface
    }

    fun bindViewHolder(userModel: UserModel) {
        Log.d(TAG, "bindViewHolder: bind")
        this.userName.text = userModel.userName
        this.userEmail.text = userModel.userEmail
        this.userPhone.text = userModel.userPhone

        Glide.with(App.instance)
             .load(userModel.userPhoto)
             .placeholder(R.drawable.ic_baseline_image_24)
             .into(this.userPhoto)

    }

    override fun onClick(v: View?) {
        Log.d(TAG, "CustomViewHolder - onClick ")
        val pos: Int = bindingAdapterPosition
        this.mClickInterface?.onItemClicked(pos)
    }

}