package com.example.loadmore.list

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.loadmore.R
import com.example.loadmore.databinding.ItemListBinding

/**
 * Created by Ankita
 */
class ListViewHolder(private val viewBinding: ItemListBinding) :
    RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(context: Context, item: Item) {
        viewBinding.apply {
            container.text = item.title
            container.setBackgroundColor(ContextCompat.getColor(context, item.background))
            container.setTextColor(
                if (item.isTextBlack) ContextCompat.getColor(
                    context,
                    R.color.black
                ) else ContextCompat.getColor(context, R.color.white)
            )
        }
    }
}