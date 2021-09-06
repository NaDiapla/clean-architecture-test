package com.example.cleanarchitecturetest.data.repository

import com.example.cleanarchitecturetest.domain.entity.RequestRemoteBookListModel
import com.example.cleanarchitecturetest.data.network.bookapi.BookApi
import com.example.cleanarchitecturetest.domain.entity.BookVolumeList
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class BookRemoteRepository @Inject constructor(
    private val bookApiClient: BookApi
) {
    fun getBookList(param: RequestRemoteBookListModel): Single<BookVolumeList> =
        bookApiClient.getBookVolumeList(param.query, param.printType, param.maxResult, param.startIndex)
}