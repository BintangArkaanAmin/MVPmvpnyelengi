package com.example.mvpnyelengi.repository.register

import android.content.Context
import com.example.mvpnyelengi.api.APIClient
import com.example.mvpnyelengi.api.APIInterface
import com.example.mvpnyelengi.api.Server
import com.example.mvpnyelengi.data.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterDataRemote : RegisterDataResource {

    private var apiInterface: APIInterface
    private lateinit var userResponseCall: Call<UserResponse>

    constructor(context: Context){
        apiInterface = APIClient.getRetrofit(context)!!.create(APIInterface::class.java)
    }

    override fun register(
        nama: String,
        email: String,
        password: String,
        registerCallback: RegisterDataResource.RegisterCallback
    ) {
        userResponseCall = apiInterface.register(nama,email, password)
        userResponseCall.enqueue(object : Callback<UserResponse>{
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                try {
                    if (response.body()!!.msg.equals("Berhasil")){
                        registerCallback.onSuccessRegister(response.body()!!.msg)
                    }else {
                        registerCallback.onErrorRegister(response.body()!!.msg)
                    }
                }catch (e: Exception){
                    e.printStackTrace()
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                registerCallback.onErrorRegister(Server.CHECK_INTERNET_CONNECTION)
            }
        })
    }
}