package com.example.customrecyclerview_project.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.customrecyclerview_project.R
import com.example.customrecyclerview_project.adapter.CustomAdapter
import com.example.customrecyclerview_project.interfaces.ClickInterface
import com.example.customrecyclerview_project.models.UserModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ClickInterface {
    val TAG: String = "logMsg"
    private lateinit var mCustomAdapter: CustomAdapter
    var userList = ArrayList<UserModel>()

    init {
        userList.add(UserModel("https://image.flaticon.com/icons/png/512/4874/4874907.png", "seunggiHong", "tmdrl1026@naver.com", "010-1234-4552"))
        userList.add(UserModel("https://image.flaticon.com/icons/png/512/4874/4874861.png", "minJeoungKim", "kim2123@naver.com", "010-1234-4557"))
        userList.add(UserModel("https://image.flaticon.com/icons/png/512/4874/4874804.png", "Jin Yang", "yddd1213@gmail.com", "010-1234-4557"))
        userList.add(UserModel("https://image.flaticon.com/icons/png/512/4874/4874766.png", "minsooPark", "adf22@naver.com", "010-1234-4557"))
        userList.add(UserModel("https://image.flaticon.com/icons/png/512/3048/3048122.png", "mooYaho", "mooYaho@gmail.com", "010-1234-4557"))
        userList.add(UserModel("https://image.flaticon.com/icons/png/512/3048/3048163.png", "chaemiSin", "sin11231@gmail.com", "010-1234-2323"))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "MainActivity - onCreate() called")

        mCustomAdapter = CustomAdapter(userList, this)
        rc_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            adapter = mCustomAdapter
        }
    }

    override fun onItemClicked(pos: Int) {
        Log.d(TAG, "MainActivity onItemClicked: $pos")
        val intent: Intent = Intent(this, ProfileActivity::class.java)
        intent.apply {
            putExtra("name", userList[pos].userName)
            putExtra("pic", userList[pos].userPhoto)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }.run{ startActivity(this) }
    }
}