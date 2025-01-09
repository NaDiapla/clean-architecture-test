package com.example.data.local.dao

import androidx.room.Insert
import androidx.room.Query
import com.example.data.model.BookItem
import kotlinx.coroutines.flow.Flow

interface BookItemDao {
    @Insert
    fun insert(vararg bookItem: BookItem): Long

    @Insert
    fun insert(bookItems: List<BookItem>): Long

    @Query("DELETE FROM book_item WHERE id = :id")
    fun delete(id: String): Long

    @Query("SELECT * FROM book_item")
    fun getAll(): Flow<List<BookItem>>

    @Query("SELECT * FROM book_item ORDER BY id DESC LIMIT 30 OFFSET :index")
    fun getItemWithOffset(index: Int): Flow<List<BookItem>>
}