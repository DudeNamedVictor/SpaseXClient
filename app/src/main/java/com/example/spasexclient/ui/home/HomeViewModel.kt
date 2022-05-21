package com.example.spasexclient.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.spasexclient.appComponent
import com.example.spasexclient.data.services.FairingsService
import com.example.spasexclient.domain.MainUseCase
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class HomeViewModel(application: Application) : AndroidViewModel(application), CoroutineScope {

    @Inject
    lateinit var service: FairingsService

    private var job: Job

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    private val _text = MutableLiveData<String>()
    val text: LiveData<String> = _text

    init {
        application.appComponent.inject(this)
        job = Job()

        launch {
            val result = withContext(Dispatchers.IO) {
                MainUseCase(service).getFairings()
            }
            if (result.isSuccessful) {
                _text.value = result.body()?.get(0)?.reused.toString()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

}