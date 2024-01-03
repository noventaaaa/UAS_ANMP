package com.example.advnative_waroengujang.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.advnative_waroengujang.R
import com.example.advnative_waroengujang.model.Menu
import com.example.advnative_waroengujang.view.ListMenuFragment.Companion.positionSelected
import com.squareup.picasso.Picasso

class ListMenuAdapter(val menuList:ArrayList<Menu>) :RecyclerView.Adapter<ListMenuAdapter.MenuViewHolder>() {
    class MenuViewHolder(var view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.menu_list_item, parent, false)
        return MenuViewHolder(view)
    }

    override fun getItemCount(): Int = menuList.size

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val lblMenuName = holder.view.findViewById<TextView>(R.id.lblMenuName)
        val lblMenuPrice = holder.view.findViewById<TextView>(R.id.lblMenuPrice)
        val cardMenu = holder.view.findViewById<CardView>(R.id.cardMenu)
        val imgMenu = holder.view.findViewById<ImageView>(R.id.imgMenu)

        Picasso.get().load(menuList[position].photo).into(imgMenu)

        lblMenuName.text = menuList[position].name
        lblMenuPrice.text = "IDR " +  menuList[position].price
        cardMenu.setOnClickListener {
            positionSelected = position
            val action = ListMenuFragmentDirections.actionListMenuFragmentToDetailMenuFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }

    fun updateListMenu(newMenuList: ArrayList<Menu>) {
        menuList.clear()
        menuList.addAll(newMenuList)
        notifyDataSetChanged()
    }
}