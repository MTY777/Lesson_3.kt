package com.example.lesson3.ui


import android.view.LayoutInflater
import androidx.recyclerview.widget.GridLayoutManager
import com.example.lesson3.R
import com.example.lesson3.base.BaseFragment
import com.example.lesson3.base.BaseViewModel
import com.example.lesson3.databinding.FragmentMainBinding
import com.example.lesson3.extensions.KEY


class MainFragment(override var viewModel: BaseViewModel) :
    BaseFragment<FragmentMainBinding, BaseViewModel>() {


    override fun inflateViewBinding(inflater: LayoutInflater): FragmentMainBinding {
        return FragmentMainBinding.inflate(inflater)
    }

    override fun initView() {
    }
    private fun onClicked(position: String) {

    }

    private fun onRemoved(position: String) {

    }

    override fun initListener() {
        binding.fab.setOnClickListener() {
            setNavigate(R.id.action_mainFragment_to_secondFragment, null)
        }
        val list = getBundle(KEY)
        binding.recyclerView.adapter =
            list.let {MainAdapter(it, requireActivity()::onClicked, requireActivity()::onRemoved)}
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
    }

    override fun initViewModel() {

    }

    override fun chekInternet() {

    }



}
