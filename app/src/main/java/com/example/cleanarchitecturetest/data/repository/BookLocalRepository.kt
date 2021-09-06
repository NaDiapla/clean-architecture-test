package com.example.cleanarchitecturetest.data.repository

import com.example.cleanarchitecturetest.data.local.dao.BookItemDao
import com.example.cleanarchitecturetest.domain.entity.BookItem
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class BookLocalRepository @Inject constructor(
    private val bookItemDao: BookItemDao
) {
    fun getFavoriteBookList(index: Int): Single<List<BookItem>> =
        // TODO Endless Scroll 구현 시 변경
        //bookItemDao.getItemWithOffset(index)
        bookItemDao.getAll()

    fun insertFavoriteBook(item: BookItem): Completable =
        bookItemDao.insert(item)

    fun deleteFavoriteBook(id: String): Completable =
        bookItemDao.delete(id)
}