package com.example.domain.usecase

import com.example.domain.repository.BookRepository
import javax.inject.Inject

class GetFavoriteBooksUseCase @Inject constructor(
    private val repository: BookRepository
) {
    suspend fun execute(index: Int) = repository.getFavoriteBooks(index)
}