package com.tz.online_shop.ui.catalog

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tz.online_shop.R
import com.tz.online_shop.databinding.FiltersItemBinding
import com.tz.online_shop.domain.models.FilterItem

class FiltersAdapter(
    private val clickListener: (FilterItem) -> Unit
) : ListAdapter<FilterItem, FiltersAdapter.ViewHolder>(ItemDiffCallback()) {

    inner class ViewHolder(private val binding: FiltersItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: FilterItem, clickListener: (FilterItem) -> Unit) {
            binding.rootCard.setOnClickListener {
                clickListener(item)
            }
            binding.textView.text = item.text
            val context = binding.root.context
            if (item.isActive) {
                binding.rootCard.setCardBackgroundColor(ContextCompat.getColor(context, R.color.elements_dark_blue))
                binding.textView.setTextColor(ContextCompat.getColor(context, R.color.white))
                binding.textView.alpha = 1.0f
            } else {
                binding.rootCard.setCardBackgroundColor(ContextCompat.getColor(context, R.color.bg_light_gray))
                binding.textView.setTextColor(ContextCompat.getColor(context, R.color.black))
                binding.textView.alpha = 0.3f
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = FiltersItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), clickListener)
    }

    class ItemDiffCallback : DiffUtil.ItemCallback<FilterItem>() {
        override fun areItemsTheSame(oldItem: FilterItem, newItem: FilterItem): Boolean {
            return oldItem.text == newItem.text
        }

        override fun areContentsTheSame(oldItem: FilterItem, newItem: FilterItem): Boolean {
            return oldItem == newItem
        }
    }
}
