package com.ncents.a160420003satujiwa.view

import android.os.Bundle
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
import com.ncents.a160420003satujiwa.model.Berita
import com.ncents.a160420003satujiwa.viewmodel.BeritaListViewModel

class BeritaListFragment : Fragment() {
    private lateinit var viewModel: BeritaListViewModel
    private val beritaListAdapter = BeritaListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_berita_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(BeritaListViewModel::class.java)
        viewModel.refresh()

        val recView = view.findViewById<RecyclerView>(R.id.recViewBerita)
        recView.layoutManager = LinearLayoutManager(context)
        recView.adapter = beritaListAdapter

        observeViewModel(view)

        val swipe = view.findViewById<SwipeRefreshLayout>(R.id.refLayout)
        val txtError = view.findViewById<TextView>(R.id.txtErrorBerita)
        val progressLoad = view.findViewById<ProgressBar>(R.id.progressLoadBerita)
        swipe.setOnRefreshListener {
            recView.visibility = View.GONE
            txtError.visibility = View.GONE
            progressLoad.visibility = View.VISIBLE
            viewModel.refresh()
            swipe.isRefreshing = false

        }
    }

    fun observeViewModel(view:View){
        viewModel.beritasLD.observe(viewLifecycleOwner, Observer{
            beritaListAdapter.updateBeritaList(it)
        })

        viewModel.beritaLoadErrorLD.observe(viewLifecycleOwner, Observer{
            val txtError = view.findViewById<TextView>(R.id.txtErrorBerita)
            if(it == true){
                txtError.visibility = View.VISIBLE
            }
            else{
                txtError.visibility = View.GONE
            }
        })

        viewModel.loadingLD.observe(viewLifecycleOwner, Observer{
            val recView = view.findViewById<RecyclerView>(R.id.recViewBerita)
            val progressLoad = view.findViewById<ProgressBar>(R.id.progressLoadBerita)
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