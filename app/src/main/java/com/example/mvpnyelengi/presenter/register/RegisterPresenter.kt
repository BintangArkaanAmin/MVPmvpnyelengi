package com.example.mvpnyelengi.presenter.register

import com.example.mvpnyelengi.repository.register.RegisterDataResource
import com.example.mvpnyelengi.repository.register.RegisterRepository

class RegisterPresenter: RegisterContract.registerPresenter {

    private val registerRepository: RegisterRepository
    private lateinit var registerView: RegisterContract.registerView

    constructor(registerRepository: RegisterRepository){
        this.registerRepository = registerRepository
    }

    override fun register(
        nama: String,
        email: String,
        password: String
    ) {
        registerRepository.register(
            nama,
            email,
            password,
            object : RegisterDataResource.RegisterCallback {
                override fun onSuccessRegister(msg: String) {
                    registerView.onSuccessRegister(msg)
                }

                override fun onErrorRegister(msg: String) {
                    registerView.onErrorRegister(msg)
                }
            })

    }

    override fun onAttachView(view: RegisterContract.registerView) {
        registerView = view
    }

    override fun onDettachView() {
        TODO("Not yet implemented")
    }
}