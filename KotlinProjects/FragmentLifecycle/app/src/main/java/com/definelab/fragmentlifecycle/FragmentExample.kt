package com.definelab.fragmentlifecycle

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FragmentExample: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.d("Fragment", "onCreateView")
        return inflater.inflate(R.layout.fragment_new,container,false)
    }

    override fun onDestroy() {
        Log.d("Fragment", "onDestroy")
        super.onDestroy()
    }

    override fun onStart() {
        Log.d("Fragment", "onStart")
        super.onStart()
    }

    override fun onStop() {
        Log.d("Fragment", "onStop")
        super.onStop()
    }

    override fun onResume() {
        Log.d("Fragment", "onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d("Fragment", "onPause")
        super.onPause()
    }
    override fun onDestroyView() {
        Log.d("Fragment", "onDestroyView")
        super.onDestroyView()
    }

    override fun onDetach() {
        Log.d("Fragment", "onDetach")
        super.onDetach()
    }

    override fun onAttach(context: Context) {
        Log.d("Fragment", "onAttach")
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("Fragment", "onViewCreated")
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        Log.d("Fragment", "onCreate")
        super.onCreate(savedInstanceState)
    }


}