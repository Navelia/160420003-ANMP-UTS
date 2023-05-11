package com.ncents.a160420003satujiwa.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ncents.a160420003satujiwa.model.Donation

class DonationListViewModel(application: Application): AndroidViewModel(application) {
    val donationsLD = MutableLiveData<ArrayList<Donation>>()
    val donationLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()
    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    fun refresh(){
        loadingLD.value = true
        donationLoadErrorLD.value = false

        queue = Volley.newRequestQueue(getApplication())
        val url = "http://10.0.2.2/ANMP/satu_jiwa_donation_detail.php"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType= object  : TypeToken<List<Donation>>() { }.type
                val result = Gson().fromJson<List<Donation>>(it, sType)
                donationsLD.value = result as ArrayList<Donation> /* = java.util.ArrayList<com.ncents.a160420003satujiwa.model.Donation> */
                loadingLD.value = false

                Log.d("showvoley", it)
            },
            {
                Log.d("showvoley", it.toString())
                donationLoadErrorLD.value = true
                loadingLD.value = false
            }
        )
        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}