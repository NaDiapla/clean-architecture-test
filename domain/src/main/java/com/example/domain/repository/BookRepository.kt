package com.example.domain.repository

import com.example.domain.entities.BookItem
import com.example.domain.entities.BookVolumes
import kotlinx.coroutines.flow.Flow

interface BookRepository {
    suspend fun getBooksRemote(
        query: String,
        printType: String = "books",
        maxResult: Int,
        startIndex: Int
    ): Flow<BookVolumes>

    suspend fun getFavoriteBooks(
        index: Int
    ): Flow<List<BookItem>>

    suspend fun insertFavoriteBook(
        item: BookItem
    )

    suspend fun deleteFavoriteBook(
        id: String
    )
}