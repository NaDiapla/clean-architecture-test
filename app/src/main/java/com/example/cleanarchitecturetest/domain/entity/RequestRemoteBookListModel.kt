package com.example.cleanarchitecturetest.domain.entity

data class RequestRemoteBookListModel(
    val query: String,
    val printType: String,
    val maxResult: Int,
    val startIndex: Int
)