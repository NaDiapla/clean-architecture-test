package com.example.data.source

import com.example.data.model.BookVolumes
import com.example.data.network.bookapi.BookApi
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val bookApiClient: BookApi
): RemoteDataSource {
    override suspend fun getBooks(
        query: String,
        printType: String,
        maxResult: Int,
        startIndex: Int
    ): BookVolumes {
        return bookApiClient.getBookVolumeList(query, printType, maxResult, startIndex)
    }
}