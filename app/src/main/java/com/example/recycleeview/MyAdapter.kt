package com.example.recycleeview

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(val List1:ArrayList<Name>,val context: Activity) :
RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
    lateinit var myListner : onClickListner
    interface onClickListner{
        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(listner:onClickListner){
        myListner = listner
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.anime,parent,false)
        return MyViewHolder(itemView,myListner )
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val currentItem = List1[position]
        holder.textView.text = currentItem.heading
        holder.description.text = currentItem.description
        holder.imageView.setImageResource(currentItem.image)

    }


    override fun getItemCount(): Int {
        return List1.size
    }
    class MyViewHolder(itemView: View,listner:onClickListner) : RecyclerView.ViewHolder(itemView) {
        val textView = itemView.findViewById<TextView>(R.id.name)
        val imageView = itemView.findViewById<ShapeableImageView>(R.id.image)
        val description = itemView.findViewById<TextView>(R.id.description)
        init{
            itemView.setOnClickListener{
                listner?.onItemClick(adapterPosition)
            }
        }
    }
}