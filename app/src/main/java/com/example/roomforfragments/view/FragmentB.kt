package com.example.roomforfragments.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.roomforfragments.R
import kotlinx.android.synthetic.main.fragment_b_layout.*

class FragmentB: Fragment(){

    lateinit var fragmentBListener:FragmentBListener

    interface FragmentBListener{
        fun communicateToActivity()
        fun communicateToFragmentA()
    }

    fun setListener(listener: FragmentBListener){
        fragmentBListener = listener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return layoutInflater.inflate(R.layout.fragment_b_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragment_b_button.setOnClickListener {
            fragmentBListener.communicateToActivity()
        }

        fragment_b_button_2.setOnClickListener {
            fragmentBListener.communicateToFragmentA()
        }
    }

    fun saysHello(){
        frag_b_textview.text = "FragmentA says hello"
    }
}