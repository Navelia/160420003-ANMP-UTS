package com.ncents.a160420003satujiwa.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ncents.a160420003satujiwa.R
import com.ncents.a160420003satujiwa.util.loadImage
import com.ncents.a160420003satujiwa.viewmodel.BeritaDetailViewModel

class BeritaDetailFragment : Fragment() {
    private lateinit var viewModel: BeritaDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_berita_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(BeritaDetailViewModel::class.java)

        if(arguments != null){
            val beritaID = BeritaDetailFragmentArgs.fromBundle(requireArguments()).beritaId

            viewModel.fetch(beritaID)
            observeViewModel(view)
        }
    }

    fun observeViewModel(view: View){
        viewModel.beritaDetailsLD.observe(viewLifecycleOwner, Observer{
            view.findViewById<TextView>(R.id.txtJudulDetail).setText(it.news_title)
            view.findViewById<ImageView>(R.id.imgBeritaDetail).loadImage(it.img_url, view.findViewById<ProgressBar>(R.id.progressBarDetailBerita))
            view.findViewById<TextView>(R.id.txtTanggal).setText(it.tanggal_rilis)
            view.findViewById<TextView>(R.id.txtBeritaIsi).setText(it.detail)
        })
    }
}