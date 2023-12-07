package com.example.mvpnyelengi.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.mvpnyelengi.MainActivity
import com.example.mvpnyelengi.R
import com.example.mvpnyelengi.di.RegisterRepositoryInject
import com.example.mvpnyelengi.presenter.register.RegisterContract
import com.example.mvpnyelengi.presenter.register.RegisterPresenter

class RegisterActivity : AppCompatActivity(),RegisterContract.registerView {

    lateinit var ETemail : EditText
    lateinit var ETpassword : EditText
    lateinit var ETnama : EditText
    lateinit var btnregister : Button

    private lateinit var registerPresenter: RegisterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        registerPresenter = RegisterPresenter(RegisterRepositoryInject.provideTo(this))
        registerPresenter.onAttachView(this)


        ETemail = findViewById(R.id.etEmailregister) as EditText
        ETpassword = findViewById(R.id.etPassregister) as EditText
        ETnama = findViewById(R.id.etNameregister) as EditText
        btnregister = findViewById(R.id.btn_register) as Button


        btnregister.setOnClickListener{
            if (ETnama.text.equals("")&&ETemail.text.equals("")&& ETpassword.text.equals("")){
                Toast.makeText(this, "Data Kosong", Toast.LENGTH_SHORT).show()
            }else{
                registerPresenter.register(ETnama.text.toString(),ETemail.text.toString(), ETpassword.text.toString())
            }
        }

    }

    override fun onSuccessRegister(msg: String) {
        Toast.makeText(this, "wow", Toast.LENGTH_SHORT).show()
        startActivity(Intent(applicationContext,MainActivity::class.java))
        finish()
    }

    override fun onErrorRegister(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

}