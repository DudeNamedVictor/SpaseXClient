package com.example.spasexclient.ui.home

import androidx.lifecycle.*
import com.example.spasexclient.data.services.FairingsService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(service: FairingsService) : ViewModel() {

    private val _textMLD = MutableLiveData<String>()
    val text: LiveData<String> = _textMLD

    init {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                HomeUseCase(service).getFairings()
            }
            if (result.isSuccessful) {
                _textMLD.value = result.body()?.get(0)?.reused.toString()
            }
        }
    }

    class BooksViewModelFactory(
        private val service: FairingsService
    ) :
        ViewModelProvider.NewInstanceFactory() {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return HomeViewModel(service) as T
        }
    }

}