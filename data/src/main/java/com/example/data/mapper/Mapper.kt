package com.example.data.mapper

import com.example.data.model.BookItem
import com.example.data.model.BookVolumes
import com.example.data.model.ImageLinks
import com.example.data.model.VolumeInfo

object Mapper {
    fun mapperToBookVolumes(bookVolumes: BookVolumes): com.example.domain.entities.BookVolumes {
        return com.example.domain.entities.BookVolumes(
            bookVolumes.items.map {
                com.example.domain.entities.BookItem(
                    it.id,
                    mapperToVolumeInfo(it.volumeInfo),
                    it.favorite
                )
            }
        )
    }

    fun mapperToBookItem(bookItem: BookItem): com.example.domain.entities.BookItem {
        return com.example.domain.entities.BookItem(
            id = bookItem.id,
            volumeInfo = mapperToVolumeInfo(bookItem.volumeInfo),
            favorite = bookItem.favorite
        )
    }

    private fun mapperToVolumeInfo(volumeInfo: VolumeInfo): com.example.domain.entities.VolumeInfo {
        return com.example.domain.entities.VolumeInfo(
            title = volumeInfo.title,
            authors = volumeInfo.authors,
            description = volumeInfo.description,
            imageLinks = volumeInfo.imageLinks?.let { mapperToImageLinks(it) }
        )
    }

    private fun mapperToImageLinks(imageLinks: ImageLinks): com.example.domain.entities.ImageLinks {
        return com.example.domain.entities.ImageLinks(
            smallThumbnail = imageLinks.smallThumbnail,
            thumbnail = imageLinks.thumbnail
        )
    }
}