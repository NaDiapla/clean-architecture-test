package com.example.data.repository

interface RemoteDataSource {
    fun getBooks(
        query: String,
        printType: String,
        maxResult: Int,
        startIndex: Int
    )
}