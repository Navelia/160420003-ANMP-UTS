package com.ncents.a160420003satujiwa.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ncents.a160420003satujiwa.R
import com.ncents.a160420003satujiwa.model.Kontributor

class KontributorListAdapter(val kontributorList:ArrayList<Kontributor>): RecyclerView.Adapter<KontributorListAdapter.KontributorViewHolder>() {
    class KontributorViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KontributorViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.contribution_list_item, parent, false)

        return KontributorViewHolder(view)
    }

    override fun onBindViewHolder(holder: KontributorViewHolder, position: Int) {
        holder.view.findViewById<TextView>(R.id.txtKontribusiDetail).text = kontributorList[position].nama + " kontribusi sebesar Rp. " + kontributorList[position].jumlah + " pada " + kontributorList[position].tanggal
    }

    override fun getItemCount(): Int {
        return kontributorList.size
    }

    fun updateKontributorList(newKontributorList: ArrayList<Kontributor>){
        kontributorList.clear()
        kontributorList.addAll(newKontributorList)
        notifyDataSetChanged()
    }
}