package com.appnews.androidtask1.ui.register

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.appnews.androidtask1.MainActivity
import com.appnews.androidtask1.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class Register : Fragment() {

    companion object {
        fun newInstance() = Register()
    }

    private lateinit var viewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (requireActivity() as MainActivity).findViewById<BottomNavigationView>(R.id.nav_view).visibility =
            View.GONE

    }

}