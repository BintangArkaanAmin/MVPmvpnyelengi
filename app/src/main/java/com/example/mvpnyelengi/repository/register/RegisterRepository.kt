package com.example.mvpnyelengi.repository.register

class RegisterRepository : RegisterDataResource {


    private var registerDataResource: RegisterDataResource

    constructor(registerDataResource: RegisterDataResource){
        this.registerDataResource = registerDataResource
    }

    override fun register(
        nama: String,
        email: String,
        password: String,
        registerCallback: RegisterDataResource.RegisterCallback
    ) {
        registerDataResource.register(
            nama,
            email,
            password,
            registerCallback

        )
    }


}