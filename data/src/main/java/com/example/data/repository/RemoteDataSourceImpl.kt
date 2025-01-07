package com.example.data.repository

import com.example.data.network.bookapi.BookApi
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val bookApiClient: BookApi
): RemoteDataSource {
    override fun getBooks(query: String, printType: String, maxResult: Int, startIndex: Int) {
        bookApiClient.getBookVolumeList(query, printType, maxResult, startIndex)
    }
}