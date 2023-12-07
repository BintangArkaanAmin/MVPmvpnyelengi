package com.example.mvpnyelengi.presenter.login

import com.example.mvpnyelengi.base.basePresenter

class LoginContract {

    interface loginView {
        fun onSuccessLogin(idUser: String, msg: String)
        fun onErrorLogin(msg: String)

    }

    interface loginPresenter : basePresenter<loginView> {
        fun login(email: String, password: String)
    }

}