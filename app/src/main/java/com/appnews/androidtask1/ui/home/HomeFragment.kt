package com.appnews.androidtask1.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.appnews.androidtask1.databinding.FragmentHomeBinding
import com.appnews.androidtask1.model.data.repository.Repository
import com.appnews.androidtask1.model.factories.ResultState
import com.appnews.androidtask1.model.pojo.Home

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val viewModel: HomeViewModel by viewModels {
        HomeViewModelFactory(Repository())
    }

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getHomeData()
        viewModel.homeLiveData.observe(viewLifecycleOwner, Observer {
            when (it) {
                is ResultState.Success -> Log.i("TAG", "onViewCreated: Success" + it.data.message)
                is ResultState.Error -> Log.i("TAG", "onViewCreated: " + it.errorString)
            }
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}