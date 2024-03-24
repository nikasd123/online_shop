package com.tz.online_shop.ui.catalog

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tz.online_shop.R
import com.tz.online_shop.databinding.ProductItemBinding
import com.tz.online_shop.domain.models.Product

class ProductListAdapter: ListAdapter<Product, ProductListAdapter.ProductViewHolder>(ProductDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ProductItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = getItem(position)
        holder.bind(product)
    }

    inner class ProductViewHolder(private val binding: ProductItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {
            with(binding) {
                productImage.setImageResource(R.drawable.product_image)
                price.text = product.price.price
                priceWithDiscount.text = product.price.priceWithDiscount + product.price.unit
                discount.text = "-${product.price.discount}%"
                productTitle.text = product.title
                productDescription.text = product.description
                rating.text = product.feedback.rating.toString()
                ratingCount.text = product.feedback.count.toString()
            }
        }
    }
}

class ProductDiffCallback : DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem == newItem
    }
}