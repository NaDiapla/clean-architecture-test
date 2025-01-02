package com.example.domain.entity

data class BookVolumes(
    val items: List<BookItem>
)

data class BookItem(
    val id: String,

    val volumeInfo: VolumeInfo,

    var favorite: Boolean = false
)

data class VolumeInfo(
    val title: String?,

    val authors: List<String>?,

    val description: String?,

    val imageLinks: ImageLinks?
)

data class ImageLinks(
    val smallThumbnail: String?,

    val thumbnail: String?
)