package com.example.loadmore

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/** Load more recycler view for providing functionality for loading more items on demand **/
class LoadMoreView : RecyclerView {

    // listener variable to be used in view classes in order to update view
    private lateinit var loadMoreListener: LoadMoreListener

    // using offset limit of 3
    private val offsetScroll: Int = 3
    private var loading = false
    private var isLoadmoreEnabled = true
    private var linearLayoutManager: LinearLayoutManager? = null

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    private val scrollListener = object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            calculateLoadMore(recyclerView, dy)
        }
    }

    private fun calculateLoadMore(
        recyclerView: RecyclerView,
        dy: Int
    ) {
        /** when scrolled upwards or data is already loading, then return **/
        if (dy <= 0 || loading) {
            return
        }
        if (linearLayoutManager == null) linearLayoutManager = layoutManager as LinearLayoutManager
        val visiblePostsCount: Int = recyclerView.childCount
        val totalPostsCount: Int = linearLayoutManager!!.itemCount
        val firstVisiblePost: Int = linearLayoutManager!!.findFirstVisibleItemPosition()
        /** calculation to decide when to load more data as per offset and visible items
         * this depends on requirement and can vary
         * **/
        if (totalPostsCount - visiblePostsCount <= firstVisiblePost + offsetScroll) {
            loading = isLoadmoreEnabled
            if (isLoadmoreEnabled) {
                loadMoreListener.onLoadMore()
            }
        }
    }

    fun enableLoadMore() {
        addOnScrollListener(scrollListener)
    }

    fun loadMoreListener(listener: LoadMoreListener) {
        this.loadMoreListener = listener
    }

    fun resetLoadMore() {
        loading = false
    }

    fun resetLoadMoreStatus(status: Boolean) {
        isLoadmoreEnabled = status
    }
}

interface LoadMoreListener {
    fun onLoadMore()
}
