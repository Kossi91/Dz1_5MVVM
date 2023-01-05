package com.example.dz1_5mvvm.data.repositories

import com.example.dz1_5mvvm.App
import com.example.dz1_5mvvm.data.models.UserModel

class UserRepository {

    fun signUp(user: UserModel) {
        App.preferenceHelper.username = user.username
        App.preferenceHelper.age = user.age
        App.preferenceHelper.email = user.email
        App.preferenceHelper.password = user.password
    }

    fun getUserInfo(): UserModel {
        App.preferenceHelper.apply {
            return UserModel(
                username = username,
                age = age,
                email = email,
                password = password
            )
        }
    }
    fun updateUserInfo(userModel: UserModel){
        App.preferenceHelper.apply {
            username = userModel.username
            age= userModel.age
            email = userModel.email
            password = userModel.password
        }
    }
}
