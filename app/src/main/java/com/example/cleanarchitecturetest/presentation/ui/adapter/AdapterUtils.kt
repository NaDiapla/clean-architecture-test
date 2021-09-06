package com.example.cleanarchitecturetest.presentation.ui.adapter

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.example.cleanarchitecturetest.R
import com.example.cleanarchitecturetest.domain.entity.BookItem

class DiffCallBack(): DiffUtil.ItemCallback<BookItem>() {
    override fun areItemsTheSame(
        oldItem: BookItem,
        newItem: BookItem
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: BookItem,
        newItem: BookItem
    ): Boolean {
        return oldItem == newItem
    }
}

/*@BindingAdapter("android:book_list_item")
fun setRecyclerViewAdapterItems(
    recyclerView: RecyclerView,
    items: List<BookItem>?
) {
    var adapter = (recyclerView.adapter as? BookListAdapter)
    recyclerView.itemAnimator = null
    if (adapter == null) {
        adapter = BookListAdapter()
        recyclerView.adapter = adapter
    }

    adapter.submitList(items.orEmpty())
}*/

@BindingAdapter("bind_thumbnail")
fun bindThumbnail(v: ImageView, url: String?) {
    Glide.with(v.context).load(url).into(v)
}

@BindingAdapter("bind_authors")
fun bindAuthors(v: TextView, authors: List<String>?) {
    if (authors != null) {
        var authorsString = ""
        for (author in authors) {
            authorsString += "$author, "
        }
        authorsString = authorsString.substring(0, authorsString.length - 2)
        v.text = authorsString
    } else {
        v.text = ""
    }
}

@BindingAdapter("bind_favorite")
fun bindFavorite(v: ImageView, isFavorite: Boolean) {
    if (isFavorite) v.setImageResource(R.drawable.ic_favorite_selected_40dp)
    else v.setImageResource(R.drawable.ic_favorite_unselected_40dp)
}