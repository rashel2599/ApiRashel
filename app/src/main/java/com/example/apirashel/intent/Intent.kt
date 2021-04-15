package com.example.apirashel.intent

sealed class Intent {
    object GetDogEvent: Intent()
    object None: Intent()
}
