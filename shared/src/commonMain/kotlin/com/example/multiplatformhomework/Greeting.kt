package com.example.multiplatformhomework

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}