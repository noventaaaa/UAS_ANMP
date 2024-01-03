package com.example.advnative_waroengujang.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.advnative_waroengujang.R
import com.example.advnative_waroengujang.model.Order

class OrderAdapter(var orderList:ArrayList<Order>) : RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {
    class OrderViewHolder(var view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.order_item, parent, false)

        return OrderViewHolder(view)

    }

    override fun getItemCount(): Int = orderList.size

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val lblTableNumberOrder = holder.view.findViewById<TextView>(R.id.lblTableNumberOrder)
        val lblTotalPrice = holder.view.findViewById<TextView>(R.id.lblTotalPrice)
        val lblDuration = holder.view.findViewById<TextView>(R.id.lblDuration)

        lblTableNumberOrder.text = orderList[position].table_number
        lblTotalPrice.text = "IDR " +  orderList[position].total_price
        lblDuration.text = "Duration: " + orderList[position].duration
    }

    fun updateListOrder(newOrderList: ArrayList<Order>) {
        orderList.clear()
        orderList.addAll(newOrderList)
        notifyDataSetChanged()
    }

}