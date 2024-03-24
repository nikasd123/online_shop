package com.tz.online_shop.ui.catalog

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.tz.online_shop.R
import com.tz.online_shop.databinding.FragmentCatalogBinding

class CatalogFragment : Fragment(R.layout.fragment_catalog) {

    private lateinit var binding: FragmentCatalogBinding
    private lateinit var filtersAdapter: FiltersAdapter
    private lateinit var productListAdapter: ProductListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCatalogBinding.bind(view)

        initFun()
    }

    private fun initFun(){
        initRecyclerViews()
        initSortTypeDropDownMenu()
    }

    private fun initSortTypeDropDownMenu(){
        val sortTypes = resources.getStringArray(R.array.sort_type)
        val arrayAdapter = context?.let {
            ArrayAdapter(it, R.layout.dropdown_item, sortTypes)
        }
        binding.autoCompleteTextView.setAdapter(arrayAdapter)
    }

    private fun initRecyclerViews(){
        binding.rvFilters.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = filtersAdapter
        }

        binding.rvProducts.apply {
            layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
            adapter = productListAdapter
        }
    }
}