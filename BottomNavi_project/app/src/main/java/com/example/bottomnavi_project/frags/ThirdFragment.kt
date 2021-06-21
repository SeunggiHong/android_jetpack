package com.example.bottomnavi_project.frags

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bottomnavi_project.R
import com.example.bottomnavi_project.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {

    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!
    private var count: Int = 0

    companion object {
        val TAG: String = "logMsg"

        fun newInstance() : ThirdFragment {
            return ThirdFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "ThirdFragment - onCreate() called")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "ThirdFragment - onAttach() called")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.d(TAG, "ThirdFragment - onCreateView() called")
//        return inflater.inflate(R.layout.fragment_third, container, false)
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        _binding?.btnThird?.setOnClickListener {
            count += 1
            _binding?.tvThird?.text = "third count = ${count}"
        }

        val view = binding.root
        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "ThirdFragment - onDestroy() called")
        _binding = null
    }
}