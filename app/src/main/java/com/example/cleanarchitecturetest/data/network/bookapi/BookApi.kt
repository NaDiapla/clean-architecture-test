package com.example.cleanarchitecturetest.data.network.bookapi

import com.example.cleanarchitecturetest.domain.entity.BookVolumeList
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface BookApi {
    @Headers("Accept: application/json")
    @GET(BaseUrl.GOOGLE_BOOKS_API_GET_VOLUME_LIST)
    fun getBookVolumeList(
        @Query("q") query: String,
        @Query("printType") printType: String,
        @Query("maxResults") maxResult: Int,
        @Query("startIndex") startIndex: Int)
    :Single<BookVolumeList>
}