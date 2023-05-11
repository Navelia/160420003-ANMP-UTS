package com.ncents.a160420003satujiwa.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ncents.a160420003satujiwa.R
import com.ncents.a160420003satujiwa.util.loadImage
import com.ncents.a160420003satujiwa.viewmodel.DonationDetailViewModel
import com.ncents.a160420003satujiwa.viewmodel.KontribusiListViewModel

class DonationDetailFragment : Fragment() {
    private lateinit var viewModel: DonationDetailViewModel
    private lateinit var kontributorViewModel: KontribusiListViewModel
    private var kontributorListAdapter = KontributorListAdapter(arrayListOf())
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_donation_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DonationDetailViewModel::class.java)
        kontributorViewModel = ViewModelProvider(this).get(KontribusiListViewModel::class.java)

        if(arguments != null) {
            val donationID = DonationDetailFragmentArgs.fromBundle(requireArguments()).donationId

            viewModel.fetch(donationID)
            kontributorViewModel.refresh(donationID)

            val recView = view.findViewById<RecyclerView>(R.id.recViewKontribusi)
            recView.layoutManager = LinearLayoutManager(context)
            recView.adapter = kontributorListAdapter

            observeViewModel(view)

            view.findViewById<Button>(R.id.btnKontribusi).setOnClickListener{
                val action = DonationDetailFragmentDirections.actionContribution(donationID)
                Navigation.findNavController(it).navigate(action)
            }
        }
    }

    fun observeViewModel(view: View){
        viewModel.donationDetailsLD.observe(viewLifecycleOwner, Observer{
            view.findViewById<TextView>(R.id.txtJudulDonasi).setText(it.donation_title)
            view.findViewById<ImageView>(R.id.imgDonasiDetail).loadImage(it.img_url, view.findViewById<ProgressBar>(R.id.progressBarDonationDetail))
            view.findViewById<TextView>(R.id.txtDonasiDibutuhkan).setText("Donasi dibutuhkan Rp. " + it.donation_needed)
            view.findViewById<TextView>(R.id.txtDonasiTerkumpul).setText("Terkumpul Rp. " + it.donation_received)
            view.findViewById<TextView>(R.id.txtJumlahKontribusi).setText(it.total_contributor.toString() + " kontribusi terkumpul")
            view.findViewById<TextView>(R.id.txtDeskripsi).setText(it.description)
        })

        kontributorViewModel.kontributorsLD.observe(viewLifecycleOwner, Observer{
            kontributorListAdapter.updateKontributorList(it)
        })
    }
}