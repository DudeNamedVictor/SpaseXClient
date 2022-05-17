package com.example.spasexclient.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.spasexclient.appComponent
import com.example.spasexclient.di.Test
import javax.inject.Inject

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    @Inject
    lateinit var test: Test

    private val _text = MutableLiveData<String>()
    val text: LiveData<String> = _text

    init {
        application.appComponent.inject(this)
        _text.value = test.test().toString()
    }
}