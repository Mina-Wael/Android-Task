package com.appnews.androidtask1.ui.home.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.appnews.androidtask1.databinding.FragmentHomeBinding
import com.appnews.androidtask1.model.data.repository.Repository
import com.appnews.androidtask1.model.factories.ResultState
import com.appnews.androidtask1.model.pojo.Save
import com.appnews.androidtask1.ui.home.viewmodel.HomeViewModel
import com.appnews.androidtask1.ui.home.viewmodel.HomeViewModelFactory
import com.bumptech.glide.Glide

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val viewModel: HomeViewModel by viewModels {
        HomeViewModelFactory(Repository())
    }

    private var categoriesAdapter: HomeCategoriesAdapter? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        initCategoriesRecycler()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getHomeData()
        viewModel.homeLiveData.observe(viewLifecycleOwner, Observer {
            when (it) {
                is ResultState.Success -> {
                    showSaveOfferData(it.data.data.saves)
                    categoriesAdapter!!.setCategories(it.data.data.categories)
                }

                is ResultState.Error -> Log.i("TAG", "onViewCreated: " + it.errorString)
            }
        })

    }

    private fun initCategoriesRecycler() {
        categoriesAdapter = HomeCategoriesAdapter(requireContext())
        binding.rvCategories.apply {
            adapter = categoriesAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
        }
    }

    private fun showSaveOfferData(saveOffers: List<Save>) {
        val save = saveOffers[0]
        binding.saveCard.saveOfferName.text = save.name
        binding.saveCard.tvSavePrice.text = save.price.toString()
        Glide.with(requireContext()).load(save.furniture_logo).into(binding.saveCard.baseImage)
        Glide.with(requireContext()).load(save.products[0].icon).into(binding.saveCard.item1Image)
        Glide.with(requireContext()).load(save.products[1].icon).into(binding.saveCard.item2Image)
        Glide.with(requireContext()).load(save.products[2].icon).into(binding.saveCard.item3Image)
        binding.saveCard.item1Name.text = save.products[0].product
        binding.saveCard.item1Num.text = save.products[0].quantity.toString()
        binding.saveCard.item2Name.text = save.products[1].product
        binding.saveCard.item2Num.text = save.products[1].quantity.toString()
        binding.saveCard.item3Name.text = save.products[2].product
        binding.saveCard.item3Num.text = save.products[2].quantity.toString()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}