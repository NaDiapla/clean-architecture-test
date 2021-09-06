package com.example.cleanarchitecturetest.presentation.delegate

import android.view.View
import androidx.lifecycle.LiveData
import com.example.cleanarchitecturetest.domain.entity.BookItem

interface ItemController: ItemClickListener {
    val favoriteBtn: LiveData<Boolean>
}

interface ItemClickListener {
    fun onFavoriteButtonClick(v: View, item: BookItem)
}