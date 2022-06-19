package com.example.loadmore.list

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.loadmore.databinding.ItemListBinding

/**
 * Created by Ankita
 */
class ListAdapter(private val mContext: Activity) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mItemList: MutableList<Item> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder: ListViewHolder = holder as ListViewHolder
        viewHolder.bind(mContext, mItemList[position])
    }

    override fun getItemCount(): Int = mItemList.size

    fun list(list: MutableList<Item>) {
        mItemList = list
        notifyDataSetChanged()
    }

    fun addList(list: MutableList<Item>) {
        mItemList.addAll(list)
        notifyDataSetChanged()
    }

}