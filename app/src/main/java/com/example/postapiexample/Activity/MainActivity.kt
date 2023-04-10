package com.example.postapiexample.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.postapiexample.DataClasses.User
import com.example.postapiexample.DataClasses.UserResponse
import com.example.postapiexample.R
import com.example.postapiexample.ViewModel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel:MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewModel()
        buttonCreate.setOnClickListener {
            createUser()
        }
    }

    private fun createUser()
    {
        val user=User("",editTextName.text.toString(),editTextEmail.text.toString(),"Active","Male")
        viewModel.createNewUser(user)
    }

    private fun initViewModel()
    {
        viewModel=ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getCreateNewUserObserver().observe(this, Observer <UserResponse?> {
            if(it==null)
            {
                Toast.makeText(this,"Failed To Create User",Toast.LENGTH_LONG).show()
            }
            else
            {
                Toast.makeText(this,"Successfully Create User",Toast.LENGTH_LONG).show()

            }
        })
    }
}