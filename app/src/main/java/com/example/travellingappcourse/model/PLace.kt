package com.example.travellingappcourse.model

import android.widget.ImageView
import java.io.Serializable

data class PLace(
        var name:String? = null,
        var location:String? = null,
        var phoneAddress:Int? = null,
        var webLink:String? = null,
        var description:String? =null,
        var image:String? = null,
        var lat:Double =0.0,
        var long:Double = 0.0
) :Serializable{

}