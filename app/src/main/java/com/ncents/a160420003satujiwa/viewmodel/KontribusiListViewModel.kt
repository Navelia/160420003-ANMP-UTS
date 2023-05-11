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
import com.google.gson.reflect.TypeToken
import com.ncents.a160420003satujiwa.model.Kontributor

class KontribusiListViewModel(application: Application): AndroidViewModel(application) {
    val kontributorsLD = MutableLiveData<ArrayList<Kontributor>>()

    val TAG = "voleyTag"
    private var queue: RequestQueue? = null

    fun refresh(id: String){
        queue = Volley.newRequestQueue(getApplication())
        val url = "http://10.0.2.2/ANMP/satu_jiwa_kontributor.php?id=" + id.toString()

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType= object  : TypeToken<List<Kontributor>>() { }.type
                val result = Gson().fromJson<List<Kontributor>>(it, sType)
                kontributorsLD.value = result as ArrayList<Kontributor> /* = java.util.ArrayList<com.ncents.a160420003satujiwa.model.Kontributor> */

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