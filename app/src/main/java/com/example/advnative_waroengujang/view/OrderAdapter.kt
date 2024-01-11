package com.example.advnative_waroengujang.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.advnative_waroengujang.R
import com.example.advnative_waroengujang.databinding.OrderItemBinding
import com.example.advnative_waroengujang.model.Order

class OrderAdapter(val orderList:ArrayList<Order>) : RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {
    class OrderViewHolder(val binding: OrderItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val binding = OrderItemBinding.inflate(
            LayoutInflater.from(parent.context),parent,false)
        return OrderViewHolder(binding)

    }

    override fun getItemCount(): Int = orderList.size

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        holder.binding.orderitem = orderList[position]
    }

    fun updateListOrder(newOrderList: ArrayList<Order>) {
        orderList.clear()
        orderList.addAll(newOrderList)
        notifyDataSetChanged()
    }

}