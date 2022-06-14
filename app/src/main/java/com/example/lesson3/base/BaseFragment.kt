package com.example.lesson3.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.example.lesson3.R


abstract class BaseFragment<VB : ViewBinding, VM : BaseViewModel> : Fragment() {
    protected lateinit var binding: VB
    protected abstract var viewModel: VM
    private var navController: NavController? = null

    protected abstract fun inflateViewBinding(inflater: LayoutInflater): VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflateViewBinding(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navHost =
            activity?.supportFragmentManager?.findFragmentById(R.id.nav_host) as NavHostFragment
        navController = navHost.navController
        chekInternet()
        initViewModel()
        initView()
        initListener()
    }

    fun setNavigate(directions: Int, data: Bundle?) {
            navController?.navigate(directions, data)
    }

    fun getBundle(key: String){
        val bundle = Bundle()
        bundle.getStringArrayList(key)
    }



    abstract fun initView()
    abstract fun initListener()
    abstract fun initViewModel()
    abstract fun chekInternet()



}