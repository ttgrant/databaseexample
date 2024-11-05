package org.database.example

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform