package com.appnews.androidtask1.ui.home.view

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.appnews.androidtask1.databinding.CategoryRowBinding
import com.appnews.androidtask1.model.pojo.Category
import com.bumptech.glide.Glide

class HomeCategoriesAdapter(private val context: Context) :
    RecyclerView.Adapter<HomeCategoriesAdapter.Holder>() {
    inner class Holder(private val binding: CategoryRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(category: Category) {
            binding.catRowText.text = category.name
            Glide.with(context).load(category.image).into(binding.catRowImage)
        }
    }

    private var categories: List<Category> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(CategoryRowBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindData(categories[position])
    }

    override fun getItemCount(): Int = categories.size

    @SuppressLint("NotifyDataSetChanged")
    fun setCategories(_categories: List<Category>) {
        categories = _categories
        notifyDataSetChanged()
    }


}