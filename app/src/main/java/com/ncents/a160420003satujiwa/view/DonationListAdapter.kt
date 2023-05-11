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
import com.ncents.a160420003satujiwa.model.Donation
import com.ncents.a160420003satujiwa.util.loadImage

class DonationListAdapter(val donationList:ArrayList<Donation>):RecyclerView.Adapter<DonationListAdapter.DonationViewHolder>() {
    class DonationViewHolder(var view:View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DonationViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.donation_list_item, parent, false)

        return DonationViewHolder(view)
    }

    override fun onBindViewHolder(holder: DonationViewHolder, position: Int) {
        holder.view.findViewById<TextView>(R.id.txtJudul).text = donationList[position].donation_title
        holder.view.findViewById<ImageView>(R.id.imgDonation).loadImage(donationList[position].img_url, holder.view.findViewById<ProgressBar>(R.id.progressBarDonation))
        holder.view.findViewById<TextView>(R.id.txtPenggalang).text = donationList[position].receiver_name
        holder.view.findViewById<TextView>(R.id.txtTotalDonasi).text = donationList[position].donation_received.toString()
        holder.view.findViewById<TextView>(R.id.txtKontributor).text = donationList[position].total_contributor.toString()

        holder.view.findViewById<Button>(R.id.btnDetailDonasi).setOnClickListener{
            val action = DonationListFragmentDirections.actionDonationDetail(donationList[position].id.toString())
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return donationList.size
    }

    fun updateDonationList(newDonationList: ArrayList<Donation>){
        donationList.clear()
        donationList.addAll(newDonationList)
        notifyDataSetChanged()
    }
}