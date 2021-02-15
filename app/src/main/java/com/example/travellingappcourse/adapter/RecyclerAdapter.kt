package com.example.travellingappcourse.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.travellingappcourse.R
import com.example.travellingappcourse.model.PLace
import kotlinx.android.synthetic.main.item_view.view.*

class RecyclerAdapter(var placeList:ArrayList<PLace>,var listener:OnClick):RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun onBind(place:PLace){
            itemView.setOnClickListener {
                listener.onItemClick(place)
            }
            itemView.imagePlace.setImageResource(place.image)
            itemView.namePlace.text = place.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.animation = AnimationUtils.loadAnimation(holder.itemView.context,R.anim.fade_transition)
        holder.onBind(placeList[position])
    }

    override fun getItemCount(): Int =  placeList.size


}

interface OnClick{
    fun onItemClick(place: PLace)
}