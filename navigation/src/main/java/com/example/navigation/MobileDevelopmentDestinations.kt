package com.example.navigation

enum class MobileDevelopmentDestinations : Destination {
    Matrix, Interview;

    companion object : Destination {
        private val groupName: String = this::class.java.name
        override val route: String = groupName
    }

    override val route: String
        get() = "${groupName}_$name"
}