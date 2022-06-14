package com.example.lesson3.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.lesson3.R
import com.example.lesson3.base.BaseFragment
import com.example.lesson3.base.BaseViewModel
import com.example.lesson3.databinding.FragmentSecondBinding
import com.example.lesson3.extensions.KEY


class SecondFragment(override var viewModel: BaseViewModel) :
    BaseFragment<FragmentSecondBinding, BaseViewModel>() {
    private lateinit var adapter: MainAdapter
    private lateinit var list: ArrayList<String>
    override fun inflateViewBinding(inflater: LayoutInflater): FragmentSecondBinding {
        return FragmentSecondBinding.inflate(inflater)
    }

    override fun initView() {
        loadData()
        adapter = MainAdapter(loadData(), this :: onClicked)
        binding.recycleView.layoutManager = GridLayoutManager(requireContext(), 3)
        binding.recycleView.adapter = adapter
    }

    private fun loadData(): ArrayList<String> {
list = ArrayList()
        list.apply {
            add("https://anews.com/upload/post/2020/11/01/120926978/gallery/tn/510165239.jpg")
            add("https://ic.pics.livejournal.com/tema/339052/2572897/2572897_1000.jpg")
            add("https://ic.pics.livejournal.com/tema/339052/2572897/2572897_1000.jpg")
            add("https://ic.pics.livejournal.com/tema/339052/2572897/2572897_1000.jpg")
            add("https://ic.pics.livejournal.com/tema/339052/2572897/2572897_1000.jpg")
            add("https://ic.pics.livejournal.com/tema/339052/2572897/2572897_1000.jpg")
            add("https://ic.pics.livejournal.com/tema/339052/2572897/2572897_1000.jpg")
            add("https://ic.pics.livejournal.com/tema/339052/2572897/2572897_1000.jpg")
            add("https://ic.pics.livejournal.com/tema/339052/2572897/2572897_1000.jpg")
            add("https://ic.pics.livejournal.com/tema/339052/2572897/2572897_1000.jpg")
            add("https://ic.pics.livejournal.com/tema/339052/2572897/2572897_1000.jpg")
            add("https://ic.pics.livejournal.com/tema/339052/2572897/2572897_1000.jpg")
            add("https://ic.pics.livejournal.com/tema/339052/2572897/2572897_1000.jpg")
            add("https://ic.pics.livejournal.com/tema/339052/2572897/2572897_1000.jpg")
            add("https://ic.pics.livejournal.com/tema/339052/2572897/2572897_1000.jpg")
            add("https://ic.pics.livejournal.com/tema/339052/2572897/2572897_1000.jpg")
            add("https://ic.pics.livejournal.com/tema/339052/2572897/2572897_1000.jpg")
        }
        return list
    }


    override fun initListener() {

    }

    override fun initViewModel() {

    }

    override fun chekInternet() {

    }
    fun onClicked(position: String) {
        binding.tvFinish.setOnClickListener(){
            binding.tvFinish.visibility = View.VISIBLE
            val bundle = Bundle()
            bundle.putStringArrayList(KEY, list)
            setNavigate(R.id.secondFragment, bundle)
        }
        list.add(position)
    }

    fun onRemoved(position: String) {
        list.remove(position)
    }


}