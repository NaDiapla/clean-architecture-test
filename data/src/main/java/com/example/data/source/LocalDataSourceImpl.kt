package com.example.data.source

import com.example.data.local.dao.BookItemDao
import com.example.data.model.BookItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val bookItemDao: BookItemDao
): LocalDataSource {
    override suspend fun insertBookItem(bookItem: BookItem): Long = bookItemDao.insert(bookItem)

    override suspend fun insertBookItems(bookItems: List<BookItem>): Long = bookItemDao.insert(bookItems)

    override suspend fun deleteBookItem(id: String): Long = bookItemDao.delete(id)

    override suspend fun getAllBookItems(): Flow<List<BookItem>> = bookItemDao.getAll()

    override suspend fun getItemWithOffset(index: Int): Flow<List<BookItem>> = bookItemDao.getItemWithOffset(index)
}