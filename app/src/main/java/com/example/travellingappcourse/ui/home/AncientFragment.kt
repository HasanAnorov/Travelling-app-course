package com.example.travellingappcourse.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.travellingappcourse.R
import com.example.travellingappcourse.databinding.FragmentAncientBinding

class AncientFragment : Fragment() {

    private lateinit var binding:FragmentAncientBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = FragmentAncientBinding.inflate(inflater,container,false)



        return binding.root
    }

}