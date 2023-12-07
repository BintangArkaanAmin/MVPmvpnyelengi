package com.example.mvpnyelengi.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.mvpnyelengi.MainActivity
import com.example.mvpnyelengi.R
import com.example.mvpnyelengi.di.LoginRepositoryInject
import com.example.mvpnyelengi.presenter.login.LoginContract
import com.example.mvpnyelengi.presenter.login.LoginPresenter

class LoginActivity : AppCompatActivity(), LoginContract.loginView {

    lateinit var ETemail : EditText
    lateinit var ETpassword : EditText
    lateinit var btnlogin : Button



    private lateinit var loginPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginPresenter = LoginPresenter(LoginRepositoryInject.provideTo(this))
        loginPresenter.onAttachView(this)


        ETemail = findViewById(R.id.etEmail) as EditText
        ETpassword = findViewById(R.id.etPass) as EditText
        btnlogin = findViewById(R.id.btn_login) as Button

        btnlogin.setOnClickListener{
            if (ETemail.text.equals("")&& ETpassword.text.equals("")){
                Toast.makeText(this, "Data Kosong", Toast.LENGTH_SHORT).show()
            }else{
                loginPresenter.login(ETemail.text.toString(),ETpassword.text.toString())
            }
        }
    }

    override fun onSuccessLogin(idUser: String, msg: String) {

        Toast.makeText(this, idUser, Toast.LENGTH_SHORT).show()
        startActivity(Intent(applicationContext, MainActivity::class.java))
        finish()
    }

    override fun onErrorLogin(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }


}