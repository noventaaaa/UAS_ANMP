package com.example.advnative_waroengujang.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.advnative_waroengujang.R
import com.example.advnative_waroengujang.databinding.FragmentDetailMenuBinding
import com.example.advnative_waroengujang.model.Cart
import com.example.advnative_waroengujang.view.HomeFragment.Companion.tableNumber
import com.example.advnative_waroengujang.viewmodel.ListMenuModel
import com.example.advnative_waroengujang.viewmodel.ListOrderModel
import com.squareup.picasso.Picasso

class DetailMenuFragment : Fragment(),ButtonAddClickListener,ButtonplusClickListener,ButtonMinClickListener {
    private lateinit var viewModel: ListMenuModel
    private lateinit var userModel: ListMenuModel
    private lateinit var orderModel: ListOrderModel
    private lateinit var dataBindingModel: FragmentDetailMenuBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBindingModel = DataBindingUtil.inflate(inflater,R.layout.fragment_detail_menu,container,false)
        return dataBindingModel.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val lblMenuNameDetail = view.findViewById<TextView>(R.id.lblMenuNameDetail)
        val lblDescriptionDetail = view.findViewById<TextView>(R.id.lblDescriptionDetail)
        val lblMenuPriceDetail = view.findViewById<TextView>(R.id.lblMenuPriceDetail)
        val lblQuantityDetail = view.findViewById<TextView>(R.id.lblQuantityDetail)
        val btnDecrease = view.findViewById<Button>(R.id.btnDecrease)
        val btnIncrease = view.findViewById<Button>(R.id.btnIncrease)
        val btnAdd = view.findViewById<Button>(R.id.btnAdd)
        val imgMenuDetail = view.findViewById<ImageView>(R.id.imgMenuDetail)

        var quantity = 1
        lblQuantityDetail.text = quantity.toString()

        btnDecrease.setOnClickListener {
            if(quantity > 1) {
                quantity--
                lblQuantityDetail.text = quantity.toString()
            }
        }

        btnIncrease.setOnClickListener {
            quantity++
            lblQuantityDetail.text = quantity.toString()
        }

        viewModel = ViewModelProvider(this).get(ListMenuModel::class.java)
        viewModel.refresh()

        lblMenuNameDetail.text = viewModel.menusLD.value!!.get(ListMenuFragment.positionSelected).name
        lblDescriptionDetail.text = viewModel.menusLD.value!!.get(ListMenuFragment.positionSelected).description
        lblMenuPriceDetail.text = "IDR " + viewModel.menusLD.value!!.get(ListMenuFragment.positionSelected).price

        Picasso.get().load(viewModel.menusLD.value!!.get(ListMenuFragment.positionSelected).photo).into(imgMenuDetail)

        btnAdd.setOnClickListener {
            val cart = Cart(viewModel.menusLD.value!!.get(ListMenuFragment.positionSelected).name,
                viewModel.menusLD.value!!.get(ListMenuFragment.positionSelected).price,
                quantity.toString())

            CartFragment.listCart.add(cart)

            quantity = 1
            lblQuantityDetail.text = quantity.toString()

            val action = DetailMenuFragmentDirections.actionDetailMenuFragmentToListMenuFragment()
            Navigation.findNavController(it).navigate(action)

            Toast.makeText(this.context, "Menu added to cart!", Toast.LENGTH_LONG).show()
        }
    }

    override fun onButtonAddClick(v: View) {
        val action = DetailMenuFragmentDirections.actionDetailMenuFragmentToCartFragment()
        Navigation.findNavController(v).navigate(action)
    }

    override fun onButtonplusClick(v: View) {
        TODO("Not yet implemented")
    }

    override fun onButtonMinClick(v: View) {
        TODO("Not yet implemented")
            }
}