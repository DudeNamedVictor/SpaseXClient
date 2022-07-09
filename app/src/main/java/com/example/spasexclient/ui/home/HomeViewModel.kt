package com.example.spasexclient.ui.home

import androidx.lifecycle.*
import com.example.spasexclient.data.models.Fairings
import com.example.spasexclient.data.services.FairingsService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Provider

class HomeViewModel @Inject constructor(service: FairingsService) : ViewModel() {

    private val _textMLD = MutableLiveData<List<Fairings>>()
    val text: LiveData<List<Fairings>> = _textMLD

    init {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                HomeUseCase(service).getFairings()
            }
            if (result.isSuccessful) {
                _textMLD.value = result.body()
            }
        }
    }

    class HomeViewModelFactory @Inject constructor(
        myViewModelProvider: Provider<HomeViewModel>
    ) : ViewModelProvider.Factory {
        private val providers = mapOf<Class<*>, Provider<out ViewModel>>(
            HomeViewModel::class.java to myViewModelProvider
        )

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return providers[modelClass]!!.get() as T
        }
    }

}