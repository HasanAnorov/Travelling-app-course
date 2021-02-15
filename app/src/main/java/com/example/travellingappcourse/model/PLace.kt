package com.example.travellingappcourse.model

import android.widget.ImageView
import java.io.Serializable

class PLace :Serializable{
    var name:String = ""
    var location:String = ""
    var phoneAddress:String = ""
    var webLink:String = ""
    var description:String =""
    var image:Int = 0
    var lat:Double =0.0
    var long:Double = 0.0



    constructor()
    constructor(name: String, location: String, phoneAddress: String, webLink: String, description: String, image: Int, lat: Double, long: Double) {
        this.name = name
        this.location = location
        this.phoneAddress = phoneAddress
        this.webLink = webLink
        this.description = description
        this.image = image
        this.lat = lat
        this.long = long
    }
}