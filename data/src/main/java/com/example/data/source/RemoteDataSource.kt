package com.example.data.source

import com.example.data.model.BookVolumes

interface RemoteDataSource {
    suspend fun getBooks(
        query: String,
        printType: String,
        maxResult: Int,
        startIndex: Int
    ): BookVolumes
}