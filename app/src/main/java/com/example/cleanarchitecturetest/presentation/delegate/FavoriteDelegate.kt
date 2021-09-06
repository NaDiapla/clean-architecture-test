package com.example.cleanarchitecturetest.presentation.delegate

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cleanarchitecturetest.R
import com.example.cleanarchitecturetest.domain.entity.BookItem
import com.example.cleanarchitecturetest.domain.usecase.DeleteFavoriteBookUseCase
import com.example.cleanarchitecturetest.domain.usecase.InsertFavoriteBookUseCase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
open class FavoriteDelegate @Inject constructor(
    private val insertFavoriteBookUseCase: InsertFavoriteBookUseCase,
    private val deleteFavoriteBookUseCase: DeleteFavoriteBookUseCase
): ItemController {
    private val _favoriteBtn = MutableLiveData<Boolean>()
    override val favoriteBtn: LiveData<Boolean> get() = _favoriteBtn

    override fun onFavoriteButtonClick(v: View, item: BookItem) {
        item.favorite = !item.favorite
        v as ImageView

        if (item.favorite) {
            v.setImageResource(R.drawable.ic_favorite_selected_40dp)
            insertFavoriteBookUseCase.execute(item)
                .subscribe(
                    { _favoriteBtn.value = item.favorite },
                    { Log.e("TESTLOG", "[onFavoriteButtonClick][insert]onError: $it") }
                )
        } else {
            v.setImageResource(R.drawable.ic_favorite_unselected_40dp)
            deleteFavoriteBookUseCase.execute(item.id)
                .subscribe(
                    { _favoriteBtn.value = item.favorite },
                    { Log.e("TESTLOG", "[onFavoriteButtonClick][delete]onError: $it") }
                )
        }
    }
}