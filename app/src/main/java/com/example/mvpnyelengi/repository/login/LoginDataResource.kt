package com.example.mvpnyelengi.repository.login

import androidx.annotation.NonNull
import com.example.mvpnyelengi.data.UserItem

interface LoginDataResource {

    fun login(email : String, password: String, @NonNull loginCallback: LoginCallback)

    interface LoginCallback {

        fun onSuccessLogin(idUser: String, msg: String)
        fun onErrorLogin(msg: String)

    }
}