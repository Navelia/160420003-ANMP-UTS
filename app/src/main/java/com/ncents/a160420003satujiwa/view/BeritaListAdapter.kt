package com.ncents.a160420003satujiwa.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ncents.a160420003satujiwa.R
import com.ncents.a160420003satujiwa.model.Berita
import com.ncents.a160420003satujiwa.util.loadImage

class BeritaListAdapter(val beritaList:ArrayList<Berita>): RecyclerView.Adapter<BeritaListAdapter.BeritaViewHolder>() {
    class BeritaViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeritaViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.berita_list_item, parent, false)

        return BeritaViewHolder(view)
    }

    override fun onBindViewHolder(holder: BeritaViewHolder, position: Int) {
        holder.view.findViewById<TextView>(R.id.txtJudulBerita).text = beritaList[position].news_title
        holder.view.findViewById<TextView>(R.id.txtSinopsis).text = beritaList[position].sinopsis

        holder.view.findViewById<Button>(R.id.btnBaca).setOnClickListener{
            val action = BeritaListFragmentDirections.actionBeritaDetail(beritaList[position].id.toString())
            Navigation.findNavController(it).navigate(action)
        }

        var imageView =holder.view.findViewById<ImageView>(R.id.imgBerita)
        var progressBar = holder.view.findViewById<ProgressBar>(R.id.progressBarBerita)
        imageView.loadImage(beritaList[position].img_url, progressBar)
    }

    override fun getItemCount(): Int {
        return beritaList.size
    }

    fun updateBeritaList(newBeritaList: ArrayList<Berita>){
        beritaList.clear()
        beritaList.addAll(newBeritaList)
        notifyDataSetChanged()
    }
}