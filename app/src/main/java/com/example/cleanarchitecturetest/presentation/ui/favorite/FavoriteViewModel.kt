package com.example.cleanarchitecturetest.presentation.ui.favorite

import android.util.Log
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanarchitecturetest.domain.entity.BookItem
import com.example.cleanarchitecturetest.domain.usecase.GetLocalFavoriteBookListUseCase
import com.example.cleanarchitecturetest.presentation.delegate.FavoriteDelegate
import com.example.cleanarchitecturetest.presentation.delegate.ItemController
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val getLocalFavoriteBookListUseCase: GetLocalFavoriteBookListUseCase,
    val favoriteDelegate: FavoriteDelegate
) : ViewModel(),
    ItemController by favoriteDelegate,
    LifecycleObserver {
    private var bookItemList = mutableListOf<BookItem>()
    private val _bookItemListLiveData = MutableLiveData<List<BookItem>>()
    val bookItemListLiveData: LiveData<List<BookItem>> get() = _bookItemListLiveData

    fun requestFavoriteBookList_old(index: Int) {
        getLocalFavoriteBookListUseCase
            .execute(index)
            .subscribe(object : SingleObserver<List<BookItem>> {
                override fun onSubscribe(d: Disposable?) {
                }

                override fun onSuccess(t: List<BookItem>?) {
                    bookItemList.clear()
                    if (t != null) {
                        for (item in t) {
                            bookItemList.add(item)
                        }
                        _bookItemListLiveData.value = bookItemList
                    }
                }

                override fun onError(e: Throwable?) {
                    Log.e("TESTLOG", "[requestFavoriteBookList] Error: $e")
                }
            })
    }

    fun requestFavoriteBookList() {
        getLocalFavoriteBookListUseCase
            .execute(0)
            .subscribe({
                if (it != null) _bookItemListLiveData.value = it.toMutableList()
            }, {
                Log.e("TESTLOG", "[requestFavoriteBookList] Error: $it")
            })
    }
}