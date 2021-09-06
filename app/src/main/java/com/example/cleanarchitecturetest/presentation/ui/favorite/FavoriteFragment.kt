package com.example.cleanarchitecturetest.presentation.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cleanarchitecturetest.databinding.FragmentFavoriteBinding
import com.example.cleanarchitecturetest.presentation.ui.adapter.BookListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment: Fragment() {

    private val favoriteViewModel: FavoriteViewModel by viewModels()

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    private val adapter by lazy { BookListAdapter(favoriteViewModel.favoriteDelegate) }
    private val layoutManager = LinearLayoutManager(this.context)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)

        favoriteViewModel.requestFavoriteBookList()

        binding.rvFavoriteList.also {
            it.layoutManager = layoutManager
            it.addItemDecoration(DividerItemDecoration(this.context, LinearLayoutManager.VERTICAL))
            it.adapter = adapter
        }

        favoriteViewModel.bookItemListLiveData.observe(viewLifecycleOwner, {
            binding.favoriteLoading.visibility = View.GONE
            it.let {
                adapter.submitList(it.toMutableList())
            }
        })

        favoriteViewModel.favoriteDelegate.favoriteBtn.observe(viewLifecycleOwner, {
            // 삭제 시에만 다시 불러옴
            if (!it) favoriteViewModel.requestFavoriteBookList()
        })

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}