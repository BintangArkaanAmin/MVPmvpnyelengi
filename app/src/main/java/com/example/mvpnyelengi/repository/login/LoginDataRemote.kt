package com.example.mvpnyelengi.repository.login

import android.content.Context
import com.example.mvpnyelengi.api.APIClient
import com.example.mvpnyelengi.api.APIInterface
import com.example.mvpnyelengi.api.Server
import com.example.mvpnyelengi.data.UserItem
import com.example.mvpnyelengi.data.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginDataRemote : LoginDataResource {

    private var apiInterface: APIInterface
    private lateinit var userResponseCall: Call<UserResponse>

    constructor(context: Context) {
        apiInterface = APIClient.getRetrofit(context)!!.create(APIInterface::class.java)
    }

    override fun login(
        email: String,
        password: String,
        loginCallback: LoginDataResource.LoginCallback
    ){

        userResponseCall = apiInterface.login(email, password)
        userResponseCall.enqueue(object : Callback<UserResponse>{
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                try {
                    if (response.body()!!.msg.equals("Berhasil")) {
                        val userResponse: UserResponse = response.body()!!
                        val userItem: List<UserItem> = userResponse.user
                        val idUser: String = userItem.get(0).idUser
                        loginCallback.onSuccessLogin(idUser, response.body()!!.msg)
                    }else{
                        loginCallback.onErrorLogin(response.body()!!.msg)
                    }
                } catch (e: Exception){
                    e.printStackTrace()
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                loginCallback.onErrorLogin(Server.CHECK_INTERNET_CONNECTION)
            }
        })
    }

}