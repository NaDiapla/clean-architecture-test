package com.example.cleanarchitecturetest.domain.usecase

import com.example.cleanarchitecturetest.data.repository.BookLocalRepository
import com.example.cleanarchitecturetest.domain.usecase.common.CompletableUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class DeleteFavoriteBookUseCase @Inject constructor(
    private val bookLocalRepository: BookLocalRepository
): CompletableUseCase<String>() {
    override fun implement(param: String): Completable {
        return bookLocalRepository.deleteFavoriteBook(param)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}