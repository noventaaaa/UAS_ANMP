package com.example.advnative_waroengujang.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.advnative_waroengujang.model.Order
import com.google.gson.Gson

class ListOrderModel : ViewModel() {
    val ordersLD = MutableLiveData<ArrayList<Order>>()

    fun refresh() {
        var gson = Gson()
        val json1 = "{\n" +
                "    \"table_number\": 5,\n" +
                "    \"total_price\": \"56000\",\n" +
                "    \"duration\": \"00:24:40\",\n" +
                "    \"detail_order\": \"2x Ayam Kremes; 2x Es Teh\"\n" +
                "  }"
        val json2 = "{\n" +
                "    \"table_number\": 12,\n" +
                "    \"total_price\": \"62000\",\n" +
                "    \"duration\": \"00:24:40\",\n" +
                "    \"detail_order\": \"1x Ayam Kalasan; 1x Ayam Kremes; 2x Es Jeruk\"\n" +
                "  }"

        var order1 = gson.fromJson(json1, Order::class.java)
        var order2 = gson.fromJson(json2, Order::class.java)
        ordersLD.value = arrayListOf(order1, order2)
    }
}