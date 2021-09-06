package com.example.cleanarchitecturetest.domain.usecase

import com.example.cleanarchitecturetest.data.repository.BookLocalRepository
import com.example.cleanarchitecturetest.domain.usecase.common.CompletableUseCase
import com.example.cleanarchitecturetest.domain.entity.BookItem
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class InsertFavoriteBookUseCase @Inject constructor(
    private val bookLocalRepository: BookLocalRepository
): CompletableUseCase<BookItem>() {

    override fun implement(param: BookItem): Completable {
        return bookLocalRepository.insertFavoriteBook(param)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}