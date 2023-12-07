package com.example.mvpnyelengi.base

interface basePresenter<T> {

    fun onAttachView(view: T)

    fun onDettachView()

}