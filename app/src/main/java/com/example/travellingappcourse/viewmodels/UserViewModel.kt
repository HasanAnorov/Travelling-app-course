package com.example.travellingappcourse.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.travellingappcourse.model.PLace
import com.example.travellingappcourse.repository.UserRepository

class UserViewModel: ViewModel() {

    private val repository = UserRepository()

    fun getMutableList(): MutableLiveData<List<PLace>> {
        return repository.getMutableLiveData()
    }

}