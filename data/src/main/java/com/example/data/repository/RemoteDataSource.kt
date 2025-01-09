package com.example.data.repository

import com.example.domain.entity.BookVolumes
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    suspend fun getBooks(
        query: String,
        printType: String,
        maxResult: Int,
        startIndex: Int
    ): BookVolumes
}