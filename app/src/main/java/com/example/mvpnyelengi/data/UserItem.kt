package com.example.mvpnyelengi.data

import com.google.gson.annotations.SerializedName

data class UserItem(

	@field:SerializedName("password")
	val password: String,

	@field:SerializedName("id_user")
	val idUser: String,

	@field:SerializedName("nama")
	val nama: String,

	@field:SerializedName("email")
	val email: String


)