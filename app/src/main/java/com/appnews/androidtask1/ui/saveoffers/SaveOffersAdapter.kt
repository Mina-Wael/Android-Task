package com.appnews.androidtask1.ui.saveoffers

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.appnews.androidtask1.databinding.SaveOffersRowBinding
import com.appnews.androidtask1.model.pojo.Save
import com.bumptech.glide.Glide

class SaveOffersAdapter(private val context: Context) :
    RecyclerView.Adapter<SaveOffersAdapter.Holder>() {

    private var saveOffers: List<Save> = emptyList()

    inner class Holder(private val binding: SaveOffersRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(save: Save) {
            binding.saveOfferName.text = save.name
            binding.tvSavePrice.text = save.price.toString()
            Glide.with(context).load(save.furniture_logo).into(binding.baseImage)
            Glide.with(context).load(save.products[0].icon).into(binding.item1Image)
            Glide.with(context).load(save.products[1].icon).into(binding.item2Image)
            Glide.with(context).load(save.products[2].icon).into(binding.item3Image)
            binding.item1Name.text = save.products[0].product
            binding.item1Num.text = save.products[0].quantity.toString()
            binding.item2Name.text = save.products[1].product
            binding.item2Num.text = save.products[1].quantity.toString()
            binding.item3Name.text = save.products[2].product
            binding.item3Num.text = save.products[2].quantity.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(SaveOffersRowBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindData(saveOffers[position])
    }

    override fun getItemCount(): Int = saveOffers.size

    @SuppressLint("NotifyDataSetChanged")
    fun setOffers(saveOfferList: List<Save>) {
        saveOffers = saveOfferList
        notifyDataSetChanged()
    }
}