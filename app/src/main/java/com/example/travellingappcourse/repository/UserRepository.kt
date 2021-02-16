package com.example.travellingappcourse.repository

import android.media.Image
import androidx.lifecycle.MutableLiveData
import com.example.travellingappcourse.model.PLace
import com.google.firebase.database.*

class UserRepository {

    private val firebaseDatabase : FirebaseDatabase = FirebaseDatabase.getInstance()
    private lateinit var  firebasePreference :DatabaseReference

    private  val mutableList =MutableLiveData<List<PLace>>()

    private lateinit var places:ArrayList<PLace>

    fun getMutableLiveData():MutableLiveData<List<PLace>>{

        firebasePreference = firebaseDatabase.getReference("users")

        firebasePreference.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                places = ArrayList()

                snapshot.children.forEach {
                    val value = it.getValue(PLace::class.java)
                    if (value!=null){
                        places.add(value)
                    }
                }
            mutableList.value=places

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })

    return mutableList

    }
}