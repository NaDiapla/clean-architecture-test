package com.example.data.source

import com.example.data.model.BookItem
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    fun insertBookItem(bookItem: BookItem): Long

    fun insertBookItems(bookItems: List<BookItem>): Long

    fun deleteBookItem(id: String): Long

    fun getAllBookItems(): Flow<List<BookItem>>

    fun getItemWithOffset(index: Int): Flow<List<BookItem>>
}