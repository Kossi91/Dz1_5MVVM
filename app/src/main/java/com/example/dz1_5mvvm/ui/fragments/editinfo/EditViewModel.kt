package com.example.dz1_5mvvm.ui.fragments.editinfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dz1_5mvvm.App
import com.example.dz1_5mvvm.data.models.UserModel
import com.example.dz1_5mvvm.data.repositories.UserRepository

class EditViewModel: ViewModel() {

    private val _userLiveData = MutableLiveData<UserModel>()
    val userLiveData: LiveData<UserModel> = _userLiveData
    private val repository = UserRepository()

    fun getInfo(): LiveData<UserModel> {
        App.preferenceHelper.apply {
            _userLiveData.value = UserModel(
                username = username,
                age = age,
                email = email,
                password = password
            )
        }
        return userLiveData
    }

    fun updateUserInfo(username: String, age: Int, email: String, password: String) {
        repository.updateUserInfo(UserModel(username, age, email, password))
    }
}