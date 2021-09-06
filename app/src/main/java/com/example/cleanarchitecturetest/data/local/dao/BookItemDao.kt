package com.example.cleanarchitecturetest.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.cleanarchitecturetest.domain.entity.BookItem
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface BookItemDao {
    @Insert
    fun insert(vararg bookItem: BookItem): Completable

    @Insert
    fun insert(bookItems: List<BookItem>): Completable

    @Query("DELETE FROM book_item WHERE id = :id")
    fun delete(id: String): Completable

    @Query("SELECT * FROM book_item")
    fun getAll(): Single<List<BookItem>>

    @Query("SELECT * FROM book_item ORDER BY id DESC LIMIT 30 OFFSET :index")
    fun getItemWithOffset(index: Int): Single<List<BookItem>>
}