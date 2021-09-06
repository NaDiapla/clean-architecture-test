package com.example.cleanarchitecturetest.domain.usecase.common

import io.reactivex.rxjava3.core.Single

abstract class SingleUseCase<in Param, Result> {
    internal abstract fun implement(param: Param): Single<Result>

    fun execute(param: Param): Single<Result> {
        return implement(param)
    }
}