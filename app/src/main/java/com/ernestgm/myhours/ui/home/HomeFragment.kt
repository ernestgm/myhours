package com.ernestgm.myhours.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ernestgm.myhours.R
import com.ernestgm.myhours.databinding.FragmentHomeBinding
import com.ernestgm.myhours.ui.home.placeholder.PlaceholderContent
import com.ernestgm.myhours.ui.slides.adapter.SlidesAdapter
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        initSlides()
        initSheduleList()
        //val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            //textView.text = it
        })
        return root
    }

    private fun initSheduleList() {
        // Set the adapter
        with(binding.recycleSheduleList) {
            layoutManager = LinearLayoutManager(context)
            adapter = SheduleListRecyclerViewAdapter(PlaceholderContent.ITEMS)
        }
    }

    private fun initSlides() {
        activity?.let {
            binding.pager.adapter = SlidesAdapter(it)
        }

        // The pager adapter, which provides the pages to the view pager widget.
        TabLayoutMediator(binding.tabs, binding.pager) { tab, position ->
        }.attach()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}