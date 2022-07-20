package com.appnews.androidtask1.ui.saveoffers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.appnews.androidtask1.databinding.FragmentSaveOffersBinding

class SaveOffers : Fragment() {


    private lateinit var viewModel: SaveOffersViewModel
    private var binding: FragmentSaveOffersBinding? = null
    private val args by navArgs<SaveOffersArgs>()

    private var offersAdapter: SaveOffersAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSaveOffersBinding.inflate(inflater)
        return binding!!.root
    }

    private fun initRecyclerView() {
        offersAdapter = SaveOffersAdapter(requireContext())
        binding!!.savOfferRecycler.apply {
            adapter = offersAdapter
            layoutManager = LinearLayoutManager(requireContext())
             setHasFixedSize(true)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        offersAdapter = null
        binding = null
    }


}