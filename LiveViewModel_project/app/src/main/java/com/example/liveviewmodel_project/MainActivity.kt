package com.example.liveviewmodel_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    val TAG: String = "logMsg"
    lateinit var mNumViewModel: NumViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mNumViewModel = ViewModelProvider(this).get(NumViewModel::class.java)
        mNumViewModel.currentValue.observe(this, Observer {
            Log.d(TAG, "MainActivity - onCreate() called $it")
            tv_text.text = it.toString()
        })

        btn_plus.setOnClickListener(this)
        btn_minus.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val userInput = et_input.text.toString().toInt()

        when(v) {
            btn_plus -> mNumViewModel.updateValue(actionType = ActionType.PLUS, userInput)
            btn_minus -> mNumViewModel.updateValue(actionType = ActionType.MINUS, userInput)
        }
    }
}