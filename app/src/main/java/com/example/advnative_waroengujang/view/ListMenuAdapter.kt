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
import com.example.advnative_waroengujang.databinding.MenuListItemBinding
import com.example.advnative_waroengujang.model.Menu
import com.example.advnative_waroengujang.view.ListMenuFragment.Companion.positionSelected
import com.squareup.picasso.Picasso

class ListMenuAdapter(val menuList:ArrayList<Menu>) :RecyclerView.Adapter<ListMenuAdapter.MenuViewHolder>() {
    class MenuViewHolder(val binding: MenuListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = MenuListItemBinding.inflate(
            LayoutInflater.from(parent.context),parent,false)
        return MenuViewHolder(binding)
    }

    override fun getItemCount(): Int = menuList.size

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.binding.menulist = menuList[position]

    }

    fun updateListMenu(newMenuList: ArrayList<Menu>) {
        menuList.clear()
        menuList.addAll(newMenuList)
        notifyDataSetChanged()
    }
}