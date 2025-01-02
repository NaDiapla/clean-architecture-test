package com.example.domain.usecase

import com.example.domain.repository.BookRepository
import javax.inject.Inject

class GetBooksUseCase @Inject constructor(
    private val repository: BookRepository
) {
    fun execute(
        query: String,
        printType: String,
        maxResult: Int,
        startIndex: Int
    ) = repository.getBooksRemote(query, printType, maxResult, startIndex)
}