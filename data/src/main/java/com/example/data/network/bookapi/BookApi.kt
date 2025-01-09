package com.example.data.network.bookapi

import com.example.domain.entity.BookVolumes
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface BookApi {
    @Headers("Accept: application/json")
    @GET(BaseUrl.GOOGLE_BOOKS_API_GET_VOLUME_LIST)
    suspend fun getBookVolumeList(
        @Query("q") query: String,
        @Query("printType") printType: String,
        @Query("maxResults") maxResult: Int,
        @Query("startIndex") startIndex: Int
    ) : BookVolumes
}