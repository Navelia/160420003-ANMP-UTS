package com.ncents.a160420003satujiwa.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.Navigation
import com.ncents.a160420003satujiwa.R
class KontribusiFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kontribusi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btnUpload).setOnClickListener{
            Toast.makeText(this.context, "Ini button upload bukti transfer", Toast.LENGTH_SHORT).show()
        }

        if(arguments != null) {
            val donationID = KontribusiFragmentArgs.fromBundle(requireArguments()).donationId

            view.findViewById<Button>(R.id.btnConfirm).setOnClickListener{
                Toast.makeText(this.context, "Ini button konfirmasi donasi", Toast.LENGTH_SHORT).show()
                val action = KontribusiFragmentDirections.actionBackToDonationDetail(donationID)
                Navigation.findNavController(it).navigate(action)
            }
        }
    }
}