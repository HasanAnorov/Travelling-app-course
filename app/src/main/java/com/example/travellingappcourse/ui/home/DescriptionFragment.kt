package com.example.travellingappcourse.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import com.example.travellingappcourse.R
import com.example.travellingappcourse.databinding.FragmentDescriptionBinding
import com.example.travellingappcourse.model.PLace
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class DescriptionFragment : Fragment(),OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    private lateinit var binding: FragmentDescriptionBinding

    @SuppressLint("ResourceType")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentDescriptionBinding.inflate(inflater,container,false)
        val place = arguments?.getSerializable("place") as PLace

//        binding.descPlaceImage.setImageResource(place.image)
//        binding.descPlaceLocation.text = place.location
//        binding.descPlacePhoneAddress.text = place.phoneAddress
//        binding.descPlaceWecLink.text = place.webLink
//        binding.descPlaceDescription.text = place.description
        val toolbar: Toolbar = activity?.findViewById(R.id.toolbar)!!
        toolbar.title=place.name
        val mapFragment = childFragmentManager.findFragmentById(R.id.google_map_fragment) as SupportMapFragment

        mapFragment.getMapAsync(this)

        return binding.root
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        if (googleMap != null) {
            mMap = googleMap
        }
        val serializable = arguments?.getSerializable("place") as PLace

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(serializable.lat, serializable.long)
        mMap.addMarker(MarkerOptions().position(sydney).title(serializable.name))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,15f))
        //mMap.mapType = GoogleMap.MAP_TYPE_SATELLITE
    }

}