package com.example.cleanarchitecturetest.domain.usecase

import com.example.cleanarchitecturetest.data.repository.BookLocalRepository
import com.example.cleanarchitecturetest.domain.usecase.common.SingleUseCase
import com.example.cleanarchitecturetest.domain.entity.BookItem
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class GetLocalFavoriteBookListUseCase @Inject constructor(
    private val bookLocalRepository: BookLocalRepository
): SingleUseCase<Int, List<BookItem>>() {

    override fun implement(index: Int): Single<List<BookItem>> {
        return bookLocalRepository.getFavoriteBookList(index*30)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}