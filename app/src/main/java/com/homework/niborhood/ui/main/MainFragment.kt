package com.homework.niborhood.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ConcatAdapter
import com.homework.niborhood.databinding.MainFragmentBinding
import com.homework.niborhood.ui.main.recyclerview.HeaderAdapter
import com.homework.niborhood.ui.main.recyclerview.StocksAdapter

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!
    val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val headerAdapter = HeaderAdapter()
        val stocksAdapter = StocksAdapter()
        val concatAdapter = ConcatAdapter(headerAdapter, stocksAdapter)

        binding.rvMain.adapter = concatAdapter

        viewModel.data.observe(viewLifecycleOwner) {
            stocksAdapter.submitList(it)
        }

        viewModel.calculatedVale.observe(viewLifecycleOwner) {
            headerAdapter.updatePortfolioValue(it)
        }

        viewModel.error.observe(viewLifecycleOwner) {
            Toast.makeText(activity, "Unable to fetch data", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}