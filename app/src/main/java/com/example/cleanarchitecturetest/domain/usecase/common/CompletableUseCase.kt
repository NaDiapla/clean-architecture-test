package com.example.cleanarchitecturetest.domain.usecase.common

import io.reactivex.rxjava3.core.Completable

abstract class CompletableUseCase<in Param> {
    internal abstract fun implement(param: Param): Completable

    fun execute(param: Param): Completable {
        return implement(param)
    }
}