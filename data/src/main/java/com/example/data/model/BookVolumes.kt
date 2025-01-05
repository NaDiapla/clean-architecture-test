package com.example.data.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class BookVolumes (
    @SerializedName("items")
    var items: List<BookItem>
)

@Entity(tableName = "book_item")
data class BookItem (
    @PrimaryKey
    @SerializedName("id")
    var id: String,

    @Embedded
    @SerializedName("volumeInfo")
    var volumeInfo: VolumeInfo,

    var favorite: Boolean = false
)

data class VolumeInfo (
    @SerializedName("title")
    var title: String?,

    @SerializedName("authors")
    var authors: List<String>?,

    @SerializedName("description")
    var description: String?,

    @Embedded
    @SerializedName("imageLinks")
    var imageLinks: ImageLinks?
)

data class ImageLinks (
    @SerializedName("thumbnail")
    var thumbnail: String
)