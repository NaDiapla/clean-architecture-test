package com.example.domain.usecase

import com.example.domain.repository.BookRepository
import javax.inject.Inject

class DeleteFavoriteUseCase @Inject constructor(
    private val repository: BookRepository
) {
    suspend fun execute(id: String) = repository.deleteFavoriteBook(id)
}