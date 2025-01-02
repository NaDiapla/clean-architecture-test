package com.example.domain.repository

import com.example.domain.entity.BookItem
import com.example.domain.entity.BookVolumes
import kotlinx.coroutines.flow.Flow

interface BookRepository {
    fun getBooksRemote(
        query: String,
        printType: String = "books",
        maxResult: Int,
        startIndex: Int
    ): Flow<BookVolumes>

    fun getFavoriteBooks(
        index: Int
    ): Flow<List<BookItem>>

    fun insertFavoriteBook(
        item: BookItem
    )

    fun deleteFavoriteBook(
        id: String
    )
}