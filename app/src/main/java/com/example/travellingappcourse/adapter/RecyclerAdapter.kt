package com.example.travellingappcourse.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.travellingappcourse.R
import com.example.travellingappcourse.databinding.ItemViewBinding
import com.example.travellingappcourse.model.PLace
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_view.view.*

class RecyclerAdapter(var listener:OnClick):RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private val itemCallback =object : DiffUtil.ItemCallback<PLace>(){
        override fun areItemsTheSame(oldItem: PLace, newItem: PLace): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: PLace, newItem: PLace): Boolean {
            return oldItem.name == newItem.name
        }
    }

    val differ =AsyncListDiffer(this,itemCallback)

    inner class ViewHolder(private val binding:ItemViewBinding):RecyclerView.ViewHolder(binding.root){
        fun onBind(place:PLace){
            binding.root.setOnClickListener {
                listener.onItemClick(place)
            }
            binding.namePlace.text = place.name

            Picasso.get().load(place.image)
                .fit()
                .centerCrop()
                .into(binding.imagePlace)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.animation = AnimationUtils.loadAnimation(holder.itemView.context,R.anim.fade_transition)
        holder.onBind(differ.currentList[position])
    }

    override fun getItemCount(): Int =  differ.currentList.size


}

interface OnClick{
    fun onItemClick(place: PLace)
}