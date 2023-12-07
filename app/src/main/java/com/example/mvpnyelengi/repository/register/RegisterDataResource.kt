package com.example.mvpnyelengi.repository.register

interface RegisterDataResource {

    fun register(
        nama: String,
        email: String,
        password: String,
        registerCallback: RegisterCallback
    )

    interface RegisterCallback{
        fun onSuccessRegister(msg:String)
        fun onErrorRegister(msg:String)
    }
}