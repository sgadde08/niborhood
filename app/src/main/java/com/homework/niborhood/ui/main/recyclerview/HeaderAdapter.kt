package com.homework.niborhood.ui.main.recyclerview

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.homework.niborhood.R
import com.homework.niborhood.databinding.HeaderItemBinding
import java.math.BigDecimal


class HeaderAdapter: RecyclerView.Adapter<HeaderAdapter.HeaderViewHolder>() {
    private var portfolioValue: BigDecimal = BigDecimal.ZERO

    /* ViewHolder for displaying header. */
    class HeaderViewHolder(private val resources:Resources, private val headerItemBinding: HeaderItemBinding) :
        RecyclerView.ViewHolder(headerItemBinding.root){

        fun bind(portfolioValue: BigDecimal) {
            headerItemBinding.myPortfolioValue.text = resources.getString(R.string.price, portfolioValue.divide(BigDecimal(100)))
        }
    }

    /* Inflates view and returns HeaderViewHolder. */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderViewHolder {
        val binding = HeaderItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HeaderViewHolder(parent.resources, binding)
    }

    /* Binds number of flowers to the header. */
    override fun onBindViewHolder(holder: HeaderViewHolder, position: Int) {
        holder.bind(portfolioValue)
    }

    /* Returns number of items, since there is only one item in the header return one  */
    override fun getItemCount(): Int {
        return 1
    }

    fun updatePortfolioValue(updatedPortfolioValue: BigDecimal) {
        portfolioValue = updatedPortfolioValue
        notifyDataSetChanged()
    }
}