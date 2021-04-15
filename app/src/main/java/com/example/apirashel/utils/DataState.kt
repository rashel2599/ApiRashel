package com.example.apirashel.utils

import com.example.apirashel.model.Dog
import java.lang.Exception

sealed class DataState {
    object Idle: DataState()
    data class Success(val dogs: List<Dog>) : DataState()
    data class Error(val exception: Exception) : DataState()
    object Loading: DataState()
}
