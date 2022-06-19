package com.example.loadmore

import android.os.Bundle
import android.os.Handler
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.loadmore.databinding.ActivityMainBinding
import com.example.loadmore.list.ListAdapter
import com.example.loadmore.list.getList

class MainActivity : AppCompatActivity(), LoadMoreListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mAdapter: ListAdapter
    private lateinit var mLayoutManager: LinearLayoutManager
    private var count = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listSetup()
        loadMoreSetup()
    }

    private fun listSetup() {
        mAdapter = ListAdapter(this)
        mLayoutManager = LinearLayoutManager(this)
        binding.list.apply {
            adapter = mAdapter
            layoutManager = mLayoutManager
        }
        mAdapter.list(getList(0))
    }

    /** initial setup for loadmore view **/
    private fun loadMoreSetup() {
        binding.list.enableLoadMore()
        binding.list.loadMoreListener(this)
    }

    /** UI condition to determine whether to load more or not
     * this is required else load more will go on for ever
     * this disables loadmore after requirements are fulfilled
     * **/
    private fun isMore(): Boolean {
        if (count < 2) {
            binding.list.resetLoadMore()
            binding.list.resetLoadMoreStatus(true)
            return true
        }
        return false
    }

    /** load more callback **/
    override fun onLoadMore() {
        if (isMore()) {
            binding.loader.visibility = VISIBLE
            Handler().postDelayed({
                binding.loader.visibility = GONE
                mAdapter.addList(getList(count))
                count++
            }, 3000)
        }
    }
}