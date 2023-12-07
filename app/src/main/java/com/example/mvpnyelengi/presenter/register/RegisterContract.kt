package com.example.mvpnyelengi.presenter.register

import com.example.mvpnyelengi.base.basePresenter

class RegisterContract {

    interface registerView{
        fun onSuccessRegister(msg: String)
        fun onErrorRegister(msg: String)
    }

    interface registerPresenter : basePresenter<registerView> {
        fun register(nama: String,email: String,password: String)
    }}