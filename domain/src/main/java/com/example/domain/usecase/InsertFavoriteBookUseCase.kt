package com.example.domain.usecase

import com.example.domain.entities.BookItem
import com.example.domain.repository.BookRepository
import javax.inject.Inject

class InsertFavoriteBookUseCase @Inject constructor(
    private val repository: BookRepository
) {
    suspend fun execute(item: BookItem) = repository.insertFavoriteBook(item)
}