package com.example.travellingappcourse.ui.home

import android.media.Image
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.travellingappcourse.R
import com.example.travellingappcourse.adapter.OnClick
import com.example.travellingappcourse.adapter.RecyclerAdapter
import com.example.travellingappcourse.databinding.ActivityMainBinding.inflate
import com.example.travellingappcourse.databinding.FragmentHomeBinding
import com.example.travellingappcourse.model.PLace

class HomeFragment : Fragment(),OnClick {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View? {

       binding = FragmentHomeBinding.inflate(inflater,container,false)

        binding.recyclerView.adapter = RecyclerAdapter(initListPro(),this)

        return binding.root
    }

    private fun initListPro(): ArrayList<PLace> {
        val places = ArrayList<PLace>()
        for (i in 0..4) {
            places.add(
                    PLace(
                            getString(R.string.zangi_name),
                            getString(R.string.zangi_address),
                            getString(R.string.zangi_tel),
                            getString(R.string.zangi_web),
                            getString(R.string.zangi_desciripyion),
                            R.drawable.zangi,41.000058, 71.672552
                    )
            )
            places.add(
                    PLace(
                            getString(R.string.dubai_name),
                            getString(R.string.dubai_addreess),
                            getString(R.string.dubai_tel),
                            getString(R.string.dubai_web),
                            getString(R.string.dubai_desciripyion),
                            R.drawable.dubai,41.000058, 71.672552
                    )
            )
            places.add(
                    PLace(
                            getString(R.string.abdulkasim_name),
                            getString(R.string.abdulkasim_address),
                            getString(R.string.abdulkasim_tel),
                            getString(R.string.abdulkasim_web),
                            getString(R.string.abdulkasim_desciripyion),
                            R.drawable.abdulkasim,41.000058, 71.672552
                    )
            )
            places.add(
                    PLace(
                            getString(R.string.jar_name),
                            getString(R.string.jar_address),
                            getString(R.string.jar_tel),
                            getString(R.string.jar_web),
                            getString(R.string.jar_desciripyion),
                            R.drawable.jar,41.000058, 71.672552
                    )
            )
            places.add(
                    PLace(
                            getString(R.string.kukeldash_name),
                            getString(R.string.kukeldash_address),
                            getString(R.string.kukeldash_tel),
                            getString(R.string.kukeldash_tel),
                            getString(R.string.kukeldash_desciripyion),
                            R.drawable.kukeldash,41.000058, 71.672552
                    )
            )
            places.add(
                    PLace(
                            getString(R.string.humo_name),
                            getString(R.string.humo_address),
                            getString(R.string.humo_tel),
                            getString(R.string.humo_web),
                            getString(R.string.humo_desciripyion),
                            R.drawable.humo,41.000058, 71.672552
                    )
            )
            places.add(
                    PLace(
                            getString(R.string.navoiy_name),
                            getString(R.string.navoiy_address),
                            getString(R.string.navoiy_tel),
                            getString(R.string.navoiy_web),
                            getString(R.string.navoiy_desciripyion),
                            R.drawable.navoiy,41.000058, 71.672552
                    )
            )
            places.add(
                    PLace(
                            getString(R.string.hilton_name),
                            getString(R.string.hilton_address),
                            getString(R.string.hilton_tel),
                            getString(R.string.hilton_web),
                            getString(R.string.hilton_desciripyion),
                            R.drawable.hilton,41.000058, 71.672552
                    )
            )
        }
        return places
    }

    override fun onItemClick(place: PLace) {

        val bundle = Bundle()
        bundle.putSerializable("place",place)
            findNavController().navigate(R.id.descriptionFragment,bundle)

    }
}
