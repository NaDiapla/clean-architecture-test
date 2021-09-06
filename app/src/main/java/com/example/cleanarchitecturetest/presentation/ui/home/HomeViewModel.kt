package com.example.cleanarchitecturetest.presentation.ui.home

import android.util.Log
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanarchitecturetest.domain.entity.BookItem
import com.example.cleanarchitecturetest.domain.entity.BookVolumeList
import com.example.cleanarchitecturetest.domain.entity.RequestRemoteBookListModel
import com.example.cleanarchitecturetest.domain.usecase.GetBookListUseCase
import com.example.cleanarchitecturetest.domain.usecase.GetLocalFavoriteBookListUseCase
import com.example.cleanarchitecturetest.presentation.delegate.FavoriteDelegate
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getBookListUseCase: GetBookListUseCase,
    private val getLocalFavoriteBookListUseCase: GetLocalFavoriteBookListUseCase,
    val favoriteDelegate: FavoriteDelegate,
) : ViewModel(),
    LifecycleObserver {
    private var bookItemList = mutableListOf<BookItem>()
    private val _bookItemListLiveData = MutableLiveData<List<BookItem>>()
    val bookItemListLiveData: LiveData<List<BookItem>> get() = _bookItemListLiveData

    private var favoriteBookItemList = mutableListOf<BookItem>()

    fun requestBookList_old(index: Int) {
        if (index == 0) {
            // 최초 실행
            requestFavoriteBookList()
        }

        getBookListUseCase.execute(generateBookListQuery(index))
            .subscribe(object :SingleObserver<BookVolumeList> {
                override fun onSubscribe(d: Disposable?) {
                }

                override fun onSuccess(t: BookVolumeList?) {
                    if (t != null) {
                        if (t.items != null) {
                            for (item in t.items) {
                                if (favoriteBookItemList.find { i -> i.id == item.id } != null)
                                    item.favorite = true
                                bookItemList.add(item)

                            }
                        }
                        _bookItemListLiveData.value = bookItemList
                    }
                }

                override fun onError(e: Throwable?) {
                    Log.e("TESTLOG", "[requestBookList] Error: $e")
                }
            })
    }

    fun requestBookList(index: Int) {
        if (index == 0) {
            // 최초 실행
            requestFavoriteBookList()
        }

        getBookListUseCase.execute(generateBookListQuery(index))
            .subscribe({
                if (it != null) {
                    if (it.items != null) {
                        for (item in it.items) {
                            if (favoriteBookItemList.find { i -> i.id == item.id } != null)
                                item.favorite = true
                            bookItemList.add(item)

                        }
                    }
                    _bookItemListLiveData.value = bookItemList
                }
            }, {
                Log.e("TESTLOG", "[requestBookList] Error: $it")
            })
    }

    private fun requestFavoriteBookList() {
        getLocalFavoriteBookListUseCase
            .execute(0)
            .subscribe({
                if (it != null) favoriteBookItemList = it.toMutableList()
            }, {
                Log.e("TESTLOG", "[requestFavoriteBookList] Error: $it")
            })
    }

    private fun generateBookListQuery(index: Int): RequestRemoteBookListModel {
        return RequestRemoteBookListModel("android", "books", 30, index * 30)
    }
}