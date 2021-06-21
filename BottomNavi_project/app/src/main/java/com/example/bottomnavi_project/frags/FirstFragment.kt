 package com.example.bottomnavi_project.frags

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bottomnavi_project.R
import com.example.bottomnavi_project.databinding.FragmentFirstBinding
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.fragment_third.view.*

 class FirstFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private var count: Int = 0

    companion object {
        val TAG: String = "logMsg"
        
        fun newInstance() : FirstFragment {
            return FirstFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "FirstFragment - onCreate() called") 
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "FirstFragment - onAttach() called") 
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.d(TAG, "FirstFragment - onCreateView() called") 
//        return inflater.inflate(R.layout.fragment_first, container, false)
        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        _binding?.btnFirst?.setOnClickListener {
            Log.d(TAG, "FirstFragment - setOnClickListener() called")
            count += 1
            _binding?.tvFirst?.text = "first count = ${count}"
        }
        val view = binding.root

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "FirstFragment - onDestroy() called")
        _binding = null
    }

    override fun onClick(v: View?) {
        Log.d(TAG, "FirstFragment - onClick() called")
    }


}