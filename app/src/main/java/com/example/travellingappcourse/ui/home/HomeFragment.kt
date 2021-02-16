package com.example.travellingappcourse.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.travellingappcourse.R
import com.example.travellingappcourse.adapter.OnClick
import com.example.travellingappcourse.adapter.RecyclerAdapter
import com.example.travellingappcourse.databinding.FragmentHomeBinding
import com.example.travellingappcourse.model.PLace
import com.example.travellingappcourse.viewmodels.UserViewModel

class HomeFragment : Fragment(),OnClick {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: RecyclerAdapter
    private lateinit var viewModel:UserViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View {
            binding = FragmentHomeBinding.inflate(inflater,container,false)

        adapter = RecyclerAdapter(this)

        viewModel = ViewModelProvider(this)[UserViewModel::class.java]

        viewModel.getMutableList().observe(requireActivity(),{
            adapter.differ.submitList(it)
        })

        binding.recyclerView.adapter = adapter

        return binding.root
    }


    override fun onItemClick(place: PLace) {

        val bundle = Bundle()
        bundle.putSerializable("place",place)
            findNavController().navigate(R.id.descriptionFragment,bundle)

    }
}
