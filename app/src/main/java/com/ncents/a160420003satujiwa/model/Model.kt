package com.ncents.a160420003satujiwa.model

data class Donation(
    val id: Int?,
    val donation_title: String?,
    val receiver_name: String?,
    val description: String?,
    val img_url: String?,
    val donation_needed: Int?,
    val donation_received: Int?,
    val total_contributor: Int?,

)