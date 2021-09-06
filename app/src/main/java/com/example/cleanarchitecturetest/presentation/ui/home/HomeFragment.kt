package com.example.cleanarchitecturetest.presentation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitecturetest.databinding.FragmentHomeBinding
import com.example.cleanarchitecturetest.presentation.ui.adapter.BookListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val adapter by lazy { BookListAdapter(homeViewModel.favoriteDelegate) }
    private val layoutManager = LinearLayoutManager(this.context)

    private var index = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        homeViewModel.requestBookList(index++)

        binding.rvBookList.also {
            it.layoutManager = layoutManager
            it.addItemDecoration(DividerItemDecoration(this.context, LinearLayoutManager.VERTICAL))
            it.adapter = adapter
            it.addOnScrollListener(object: RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    if (layoutManager.findLastVisibleItemPosition() > adapter.itemCount - 5) {
                        homeViewModel.requestBookList(index++)
                    }
                }
            })
        }

        homeViewModel.bookItemListLiveData.observe(viewLifecycleOwner, {
            binding.homeLoading.visibility = View.GONE
            it.let {
                adapter.submitList(it.toMutableList())
            }
        })

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}