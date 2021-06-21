package com.example.bottomnavi_project.frags

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bottomnavi_project.R
import com.example.bottomnavi_project.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    private var count: Int = 0

    companion object {
        val TAG: String = "logMsg"

        fun newInstance() : SecondFragment {
            return SecondFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "SecondFragment - onCreate() called")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "SecondFragment - onAttach() called")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.d(TAG, "SecondFragment - onCreateView() called")
//        return inflater.inflate(R.layout.fragment_second, container, false)
        _binding = FragmentSecondBinding.inflate(inflater, container, false)

        _binding?.btnSecond?.setOnClickListener {
            count += 1
            _binding?.tvSecond?.text = "second count = ${count}"
        }

        val view = binding.root

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "SecondFragment - onDestroy() called")
        _binding = null
    }
}