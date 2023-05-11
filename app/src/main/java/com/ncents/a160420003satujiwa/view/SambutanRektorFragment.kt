package com.ncents.a160420003satujiwa.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.ncents.a160420003satujiwa.R

class SambutanRektorFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sambutan_rektor, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnYayasan = view.findViewById<Button>(R.id.btnYayasan)
        btnYayasan.setOnClickListener{
            val action = SambutanRektorFragmentDirections.actionSambutanYayasan()
            Navigation.findNavController(it).navigate(action)
        }

    }
}