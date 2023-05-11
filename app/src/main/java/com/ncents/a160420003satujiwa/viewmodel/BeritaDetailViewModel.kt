package com.ncents.a160420003satujiwa.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.ncents.a160420003satujiwa.model.Berita

class BeritaDetailViewModel(application: Application): AndroidViewModel(application) {
    val beritaDetailsLD = MutableLiveData<Berita>()

    val TAG = "voleyTag"
    private var queue: RequestQueue? = null

    fun fetch(id: String){
        queue = Volley.newRequestQueue(getApplication())
        val url = "http://10.0.2.2/ANMP/satu_jiwa_berita_detail.php?id=" + id.toString()

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val result = Gson().fromJson<Berita>(it, Berita::class.java)
                beritaDetailsLD.value = result

                Log.d("showvoley", it)
            },
            {
                Log.d("showvoley", it.toString())
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