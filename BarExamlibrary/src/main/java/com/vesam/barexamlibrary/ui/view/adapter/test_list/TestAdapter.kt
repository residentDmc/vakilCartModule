package com.vesam.barexamlibrary.ui.view.adapter.test_list

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vesam.barexamlibrary.R
import com.vesam.barexamlibrary.data.model.Test
import com.vesam.barexamlibrary.interfaces.OnClickListenerAny
import java.util.*

class TestAdapter(private val context: Context) : RecyclerView.Adapter<ViewHolderTest>() {

    private val list: ArrayList<Test> = ArrayList()
    private lateinit var onClickListenerAny: OnClickListenerAny

    fun setOnItemClickListener(onClickListenerAny: OnClickListenerAny) {
        this.onClickListenerAny = onClickListenerAny
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderTest =
        ViewHolderTest(getViewHolder(parent))

    private fun getViewHolder(parent: ViewGroup): View = LayoutInflater.from(context)
        .inflate(R.layout.item_test, parent, false)

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolderTest, position: Int) {
        val test = list[position]
        holder.txtTitle.text = test.title
        holder.txtDescription.text = test.description
        holder.txtQuestionCount.text = test.questionCount
        holder.txtMoney.text = test.money
        holder.image.setImageResource(test.imageId)
        holder.lnParent.setOnClickListener { onClickListenerAny.onClickListener(test) }
    }

    override fun getItemCount(): Int = list.size

    fun updateList(listTest: List<Test>) {
        list.clear()
        list.addAll(listTest)
        notifyDataSetChanged()
    }
}