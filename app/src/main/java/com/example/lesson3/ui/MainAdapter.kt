package com.example.lesson3.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson3.databinding.ItemBinding
import com.example.lesson3.extensions.load
import java.util.*

class MainAdapter(
    var data: List<String>,
    private var onClicked: (image: String) -> Unit?,
private var onRemoved: (image: String) -> Unit?
) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    lateinit var binding: ItemBinding


    @SuppressLint("NotifyDataSetChanged")
    fun addList(list: List<String>) {
        this.data = list
        Collections.reverse(this.data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class MainViewHolder(private var binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: String) {
            binding.ivFirst.load(model)
            if (binding.background.visibility == View.GONE) {
                binding.background.visibility = View.VISIBLE
                onClicked(model)
            } else {
                binding.background.visibility = View.GONE
                onRemoved(model)
            }
        }
    }

}
