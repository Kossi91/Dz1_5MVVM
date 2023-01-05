package com.example.dz1_5mvvm.ui.fragments.signup

import androidx.lifecycle.ViewModel
import com.example.dz1_5mvvm.App
import com.example.dz1_5mvvm.data.models.UserModel
import com.example.dz1_5mvvm.data.repositories.UserRepository

class SignUpViewModel: ViewModel() {

    private val  repository = UserRepository()

    fun signUp(username : String, age : Int, email : String, password: String ){
       repository.signUp(UserModel(username,age,email,password))
    }
}