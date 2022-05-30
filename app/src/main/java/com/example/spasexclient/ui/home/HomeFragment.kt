package com.example.spasexclient.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.spasexclient.appComponent
import com.example.spasexclient.data.services.FairingsService
import com.example.spasexclient.databinding.FragmentHomeBinding
import javax.inject.Inject


class HomeFragment : Fragment() {

    @Inject
    lateinit var service: FairingsService

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by viewModels {
        HomeViewModel.BooksViewModelFactory(service)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        activity?.appComponent?.inject(this)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.text.observe(viewLifecycleOwner, {
            binding.recyclerView.adapter = HomeAdapter(it)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}