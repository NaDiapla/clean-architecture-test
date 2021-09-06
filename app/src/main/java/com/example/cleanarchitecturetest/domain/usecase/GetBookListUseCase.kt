package com.example.cleanarchitecturetest.domain.usecase

import com.example.cleanarchitecturetest.domain.entity.RequestRemoteBookListModel
import com.example.cleanarchitecturetest.data.repository.BookRemoteRepository
import com.example.cleanarchitecturetest.domain.entity.BookVolumeList
import com.example.cleanarchitecturetest.domain.usecase.common.SingleUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class GetBookListUseCase @Inject constructor(
    private val bookRemoteRepository: BookRemoteRepository,
): SingleUseCase<RequestRemoteBookListModel, BookVolumeList>() {

    override fun implement(param: RequestRemoteBookListModel): Single<BookVolumeList> {
        return bookRemoteRepository.getBookList(param)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}