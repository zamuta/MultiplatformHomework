package com.example.multiplatformhomework.network

// itV4cbFUXsuNfzGubDIN2nGnaOPFxs6H0Pl0Cxc0
// zoF0vLrnZn9v8owS6Ev4xxsOUUG4SWMA62JZvGbG
// jHOR9GuzkO8cghjEDTHtQGddUhJL9FvMYDx8Gx3s
class NetworkConfig constructor(
    var apiUrl: String = "https://api.thenewsapi.com/v1",
    var apiToken: String = "",
) {
    companion object {
        val shared = NetworkConfig(apiToken = "jHOR9GuzkO8cghjEDTHtQGddUhJL9FvMYDx8Gx3s")
    }
}