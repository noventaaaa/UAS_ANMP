package com.example.advnative_waroengujang.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.advnative_waroengujang.R
import com.example.advnative_waroengujang.model.Cart
import com.example.advnative_waroengujang.viewmodel.ListMenuModel

class CartFragment : Fragment() {
    companion object {
        var listCart = ArrayList<Cart>()
    }

    private lateinit var viewCf: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val lblTableNumber = view.findViewById<TextView>(R.id.lblTableNumberCart)
        lblTableNumber.text = "Table Number " + HomeFragment.tableNumber

        var cartAdapter = CartAdapter(listCart)

        var listCart = view.findViewById<RecyclerView>(R.id.listCart)
        listCart.layoutManager = LinearLayoutManager(this.context)
        listCart.adapter = cartAdapter

        viewCf = view
        calculate()

        val btnProcess = view.findViewById<Button>(R.id.btnProcess)
        btnProcess.setOnClickListener {
            Companion.listCart = ArrayList()
            cartAdapter = CartAdapter(Companion.listCart)

            listCart = view.findViewById<RecyclerView>(R.id.listCart)
            listCart.layoutManager = LinearLayoutManager(this.context)
            listCart.adapter = cartAdapter

            calculate()

            Toast.makeText(this.context, "Cart has been sent to kitchen!", Toast.LENGTH_LONG).show()
        }
    }

    override fun onResume() {
        super.onResume()
        calculate()
    }

    override fun onStart() {
        super.onStart()
        calculate()
    }

    fun calculate() {
        val lblSubtotal = viewCf.findViewById<TextView>(R.id.lblSubtotal)
        val lblTax = viewCf.findViewById<TextView>(R.id.lblTax)
        val lblTotal = viewCf.findViewById<TextView>(R.id.lblTotal)

        var subtotal = 0
        for(cart in listCart) {
            subtotal += (Integer.parseInt(cart.menu_price) * Integer.parseInt(cart.quantity))
        }

        var tax = subtotal * 10 / 100
        var total = subtotal + tax

        lblSubtotal.text = "IDR " +  subtotal.toString()
        lblTax.text = "IDR " +  tax.toString()
        lblTotal.text = "IDR " +  total.toString()
    }
}