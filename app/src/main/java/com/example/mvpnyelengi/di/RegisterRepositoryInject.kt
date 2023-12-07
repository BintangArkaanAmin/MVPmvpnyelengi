package com.example.mvpnyelengi.di

import android.content.Context
import com.example.mvpnyelengi.repository.register.RegisterDataRemote
import com.example.mvpnyelengi.repository.register.RegisterRepository

class RegisterRepositoryInject {
    companion object{
        fun provideTo(context: Context):RegisterRepository{
            return RegisterRepository(RegisterDataRemote(context))
        }
    }
}