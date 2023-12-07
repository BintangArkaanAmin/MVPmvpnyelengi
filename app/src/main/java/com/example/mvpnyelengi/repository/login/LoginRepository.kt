package com.example.mvpnyelengi.repository.login

class LoginRepository : LoginDataResource {

    private val loginDataResource: LoginDataResource

    constructor(loginDataResource: LoginDataResource){
        this.loginDataResource = loginDataResource
    }

    override fun login(
        email: String,
        password: String,
        loginCallback: LoginDataResource.LoginCallback
    ){
        loginDataResource.login(email,password, loginCallback)
    }



}