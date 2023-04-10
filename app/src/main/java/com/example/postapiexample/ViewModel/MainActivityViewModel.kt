package com.example.postapiexample.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.postapiexample.DataClasses.User
import com.example.postapiexample.DataClasses.UserResponse
import com.example.postapiexample.Instances.RetroInstances
import com.example.postapiexample.Interfaces.RetroServiceInstances
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel:ViewModel()
{
    lateinit var createNewUserLiveData:MutableLiveData<UserResponse?>
    init {
        createNewUserLiveData= MutableLiveData()
    }

    fun getCreateNewUserObserver():MutableLiveData<UserResponse?>
    {
        return createNewUserLiveData
    }

    fun createNewUser(user:User)
    {
        val retroService =RetroInstances.getRetroInstance().create(RetroServiceInstances::class.java)
        val call =retroService.createUser(user)
        call.enqueue(object:Callback<UserResponse>{
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if (response.isSuccessful)
                {
                    createNewUserLiveData.postValue(response.body())
                }
                else
                {
                    createNewUserLiveData.postValue(null)
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                createNewUserLiveData.postValue(null)
            }

        })
    }
}