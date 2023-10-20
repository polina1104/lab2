package com.example.myapplication.viewmodel

import androidx.lifecycle.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CounterViewModel : ViewModel() {
    private val _counter = MutableLiveData(0)

    val counter: LiveData<Int>
        get() = _counter

    fun incrementCounter(value: Int) {
        viewModelScope.launch {
            delay(3000)
            _counter.value = _counter.value?.plus(value)
        }
    }

    fun decrementCounter(value: Int) {
        viewModelScope.launch {
            delay(3000)
            _counter.value = _counter.value?.minus(value)
        }
    }
}
