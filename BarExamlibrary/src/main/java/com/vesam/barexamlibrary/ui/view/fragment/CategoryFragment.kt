package com.vesam.barexamlibrary.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vesam.barexamlibrary.R
import com.vesam.barexamlibrary.databinding.FragmentCategoryBinding
import com.vesam.barexamlibrary.interfaces.OnClickListenerAny
import com.vesam.barexamlibrary.ui.view.adapter.category_list.CategoryAdapter
import com.vesam.barexamlibrary.utils.application.AppQuiz
import org.koin.android.ext.android.inject

class CategoryFragment : Fragment() {

    private lateinit var binding: FragmentCategoryBinding
    private val navController: NavController by inject()
    private val categoryAdapter: CategoryAdapter by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCategoryBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        try {
            initAction()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun initAction() {
        initToolbar()
        initAdapter()
    }

    private fun initAdapter() {
        binding.rcCategory.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        binding.rcCategory.setHasFixedSize(true)
        binding.rcCategory.adapter = categoryAdapter
        categoryAdapter.updateList(getList())
        categoryAdapter.setOnItemClickListener(object : OnClickListenerAny {
            override fun onClickListener(any: Any) = initItemClickListener(any)
        })
    }

    private fun initItemClickListener(any: Any) {
        navController.navigate(R.id.testFragment)
    }


    private fun getList(): List<String> {
        val categoryList: ArrayList<String> = ArrayList()
        categoryList.add("حقوق و جزا")
        categoryList.add("دعوی خانوادگی")
        return categoryList
    }

    private fun initToolbar() {
        initAppCompatActivityToolbar()
    }

    private fun initAppCompatActivityToolbar() {
        (AppQuiz.activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (AppQuiz.activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationIcon(R.drawable.ic_arrow_back_toolbar)
        binding.toolbar.setNavigationOnClickListener { initFinish() }
    }

    private fun initFinish() {
        AppQuiz.activity.finish()
    }
}