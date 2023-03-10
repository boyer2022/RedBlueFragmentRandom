package com.example.redbluefragment_randomnumber

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

/**
 * A simple [Fragment] subclass.
 * Use the [BlueFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlueFragment : Fragment() {
    private lateinit var displayRandomTextView: TextView
    private val randomNumberViewModel:RandomNumberViewModel by lazy {
        // lazy{} means - I'll describe how to create the RandomNumberViewModel, but the initialization won't run until
        // that ViewModel is actually accessed
        ViewModelProvider(requireActivity()).get(RandomNumberViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_blue, container, false)
        displayRandomTextView = view.findViewById(R.id.random_number_textview)

//        showRandomNumber()
        randomNumberViewModel.randomNumber.observe(requireActivity()) {
            // the new value -> task to do with the new value
            random -> showRandomNumber(random)
        }

        return view
    }
    private fun showRandomNumber(randomNumber: Int) {
        displayRandomTextView.text = randomNumber.toString()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         */
        @JvmStatic
        fun newInstance() = BlueFragment()
    }
}