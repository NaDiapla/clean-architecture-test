package com.example.cleanarchitecturetest.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitecturetest.R
import com.example.cleanarchitecturetest.databinding.ItemBookBinding
import com.example.cleanarchitecturetest.domain.entity.BookItem
import com.example.cleanarchitecturetest.presentation.delegate.ItemClickListener

class BookListAdapter(
    val itemClickListener: ItemClickListener
) : ListAdapter<BookItem, BookListAdapter.ViewHolder>(DiffCallBack())
{
    inner class ViewHolder(
        private val binding: ItemBookBinding
        ): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: BookItem) {
            binding.bookItem = item
            binding.onItemClickListener = itemClickListener
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_book, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}