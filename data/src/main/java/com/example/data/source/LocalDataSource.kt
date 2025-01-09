package com.example.data.source

import com.example.data.model.BookItem
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    suspend fun insertBookItem(bookItem: BookItem): Long

    suspend fun insertBookItems(bookItems: List<BookItem>): Long

    suspend fun deleteBookItem(id: String): Long

    suspend fun getAllBookItems(): Flow<List<BookItem>>

    suspend fun getItemWithOffset(index: Int): Flow<List<BookItem>>
}