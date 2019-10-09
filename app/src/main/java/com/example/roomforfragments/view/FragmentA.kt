package com.example.roomforfragments.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.roomforfragments.R
import kotlinx.android.synthetic.main.fragment_a_layout.*

class FragmentA : Fragment(){

    companion object{
        const val valueKey = "get_value"
    }

    private lateinit var fragmentAListener: FragmentAListener

    interface FragmentAListener{
        fun fragmentAButtonPressed()
    }

    fun setFragmentAListener(listener: FragmentAListener){
        fragmentAListener = listener
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_a_layout, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let { myBundle ->
            frag_a_textview.text = myBundle.getString(valueKey)
        }

        fragment_a_button.setOnClickListener { _ ->

            fragmentAListener.fragmentAButtonPressed()

        }
    }

    fun saysHello(){
        frag_a_textview.text = "FragmentB says hello"
    }
}