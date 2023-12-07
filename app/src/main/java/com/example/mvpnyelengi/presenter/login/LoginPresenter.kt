package com.example.mvpnyelengi.presenter.login

import com.example.mvpnyelengi.repository.login.LoginDataResource
import com.example.mvpnyelengi.repository.login.LoginRepository

class LoginPresenter : LoginContract.loginPresenter {

    private var loginRepository: LoginRepository
    private lateinit var loginView: LoginContract.loginView

    constructor(loginRepository: LoginRepository) {
        this.loginRepository = loginRepository
    }

    override fun login(email: String, password: String) {
        loginRepository.login(email, password, object : LoginDataResource.LoginCallback {
            override fun onSuccessLogin(idUser: String, msg: String) {
                loginView.onSuccessLogin(idUser, msg)
            }

            override fun onErrorLogin(msg: String) {
                loginView.onErrorLogin(msg)
            }

        })
    }

    override fun onAttachView(view: LoginContract.loginView) {
        loginView = view
    }

    override fun onDettachView() {

    }
}


