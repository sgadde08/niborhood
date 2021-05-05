package com.homework.niborhood.ui.main.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.homework.niborhood.databinding.ItemPositionBinding
import com.homework.niborhood.network.model.PositionModel

class StocksAdapter :
    ListAdapter<PositionModel, StocksAdapter.StocksViewHolder>(StocksDiffCallback) {

    class StocksViewHolder(private val itemViewBinding: ItemPositionBinding) :
        RecyclerView.ViewHolder(itemViewBinding.root) {

        fun bind(stock: PositionModel) {
            itemViewBinding.positionModel = stock
        }
    }

    /* Creates and inflates view and return FlowerViewHolder. */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StocksViewHolder {
        val binding = ItemPositionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StocksViewHolder(binding)
    }

    /* Gets current flower and uses it to bind view. */
    override fun onBindViewHolder(holder: StocksViewHolder, position: Int) {
        holder.bind(currentList[position])

    }
}

object StocksDiffCallback : DiffUtil.ItemCallback<PositionModel>() {
    override fun areItemsTheSame(oldItem: PositionModel, newItem: PositionModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: PositionModel, newItem: PositionModel): Boolean {
        return oldItem.ticker == newItem.ticker
    }
}