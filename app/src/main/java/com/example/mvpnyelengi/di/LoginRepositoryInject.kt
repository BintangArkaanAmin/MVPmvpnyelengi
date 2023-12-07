package com.example.mvpnyelengi.di

import android.content.Context
import com.example.mvpnyelengi.repository.login.LoginDataRemote
import com.example.mvpnyelengi.repository.login.LoginRepository

class LoginRepositoryInject {
    companion object {
        fun provideTo(context: Context) : LoginRepository {
            return LoginRepository(LoginDataRemote(context))
        }
    }
}