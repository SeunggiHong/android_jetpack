package com.example.bottomnavi_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.bottomnavi_project.databinding.ActivityMainBinding
import com.example.bottomnavi_project.frags.FirstFragment
import com.example.bottomnavi_project.frags.SecondFragment
import com.example.bottomnavi_project.frags.ThirdFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var firstFragment: FirstFragment
    private lateinit var secondFragment: SecondFragment
    private lateinit var thirdFragment: ThirdFragment

    val TAG: String = "logMsg"

    private var activityMainBinding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        activityMainBinding = binding

        setContentView(activityMainBinding!!.root)
//        setContentView(R.layout.activity_main)
        Log.d(TAG, "MainActivity - onCreate() called")

        activityMainBinding?.bnView?.setOnNavigationItemSelectedListener(onBottomNaviItemSelectedListener)

        firstFragment = FirstFragment.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.fl_main_view, firstFragment).commit()
    }

    private val onBottomNaviItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
        when (it.itemId) {
            R.id.menu_first -> {
                activityMainBinding?.tvTitle?.text = "FIRST BUTTON CLICKED"

                Log.d(TAG, "MainActivity - menu_first called")
                firstFragment = FirstFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fl_main_view, firstFragment).commit()
            }
            R.id.menu_second -> {
                activityMainBinding?.tvTitle?.text = "SECOND BUTTON CLICKED"

                Log.d(TAG, "MainActivity - menu_second called")
                secondFragment = SecondFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fl_main_view, secondFragment).commit()
            }
            R.id.menu_third -> {
                activityMainBinding?.tvTitle?.text = "THIRD BUTTON CLICKED"

                Log.d(TAG, "MainActivity - menu_third called")
                thirdFragment = ThirdFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fl_main_view, thirdFragment).commit()
            }
        }
        true
    }
}