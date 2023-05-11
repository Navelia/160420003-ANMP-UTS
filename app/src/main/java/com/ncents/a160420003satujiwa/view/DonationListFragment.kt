package com.ncents.a160420003satujiwa.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.ncents.a160420003satujiwa.R
import com.ncents.a160420003satujiwa.viewmodel.DonationListViewModel

class DonationListFragment : Fragment() {
    private lateinit var viewModel: DonationListViewModel
    private var donationListAdapter = DonationListAdapter(arrayListOf())
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.d("checkfragment", "checkfragment")
        return inflater.inflate(R.layout.fragment_donation_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DonationListViewModel::class.java)
        viewModel.refresh()

        val recView = view.findViewById<RecyclerView>(R.id.recViewDonation)
        recView.layoutManager = LinearLayoutManager(context)
        recView.adapter = donationListAdapter

        observeViewModel(view)

        val swipe = view.findViewById<SwipeRefreshLayout>(R.id.refreshLayout)
        val txtError = view.findViewById<TextView>(R.id.txtError)
        val progressLoad = view.findViewById<ProgressBar>(R.id.progressLoad)
        swipe.setOnRefreshListener {
            recView.visibility = View.GONE
            txtError?.visibility = View.GONE
            progressLoad?.visibility = View.VISIBLE
            viewModel.refresh()
            swipe.isRefreshing = false
        }
    }

    fun observeViewModel(view:View){
        viewModel.donationsLD.observe(viewLifecycleOwner, Observer{
            donationListAdapter.updateDonationList(it)
        })

        viewModel.donationLoadErrorLD.observe(viewLifecycleOwner, Observer{
            val txtError = view.findViewById<TextView>(R.id.txtError)
            if(it == true){
                txtError.visibility = View.VISIBLE
            }
            else{
                txtError.visibility = View.GONE
            }
        })

        viewModel.loadingLD.observe(viewLifecycleOwner, Observer{
            val recView = view.findViewById<RecyclerView>(R.id.recViewDonation)
            val progressLoad = view.findViewById<ProgressBar>(R.id.progressLoad)
            if(it == true){
                recView.visibility = View.GONE
                progressLoad.visibility = View.VISIBLE
            }
            else{
                recView.visibility = View.VISIBLE
                progressLoad.visibility = View.GONE
            }
        })
    }
}