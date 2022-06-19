package com.example.loadmore.list

import com.example.loadmore.R

/**
 * Created by Ankita
 */
data class Item(
    var title: String = "",
    var background: Int = 0,
    var isTextBlack: Boolean = false
)

val list0: MutableList<Item> = arrayListOf(Item("Red", R.color.red),Item("Black", R.color.black),Item("White", R.color.white, true),Item("Blue", R.color.blue),Item("Purple", R.color.purple_200),Item("Green", R.color.green),)
val list1: MutableList<Item> = arrayListOf(Item("Yellow", R.color.yellow, true),Item("Pink", R.color.pink),Item("Violet", R.color.violet),Item("Orange", R.color.orange),Item("Grey", R.color.grey),Item("Teal", R.color.teal_200),)
val list2: MutableList<Item> = arrayListOf(Item("Red", R.color.red),Item("Black", R.color.black),Item("White", R.color.white, true),Item("Blue", R.color.blue),Item("Purple", R.color.purple_200),Item("Green", R.color.green),)
val list3: MutableList<Item> = arrayListOf(Item("Yellow", R.color.yellow, true),Item("Pink", R.color.pink),Item("Violet", R.color.violet),Item("Orange", R.color.orange),Item("Grey", R.color.grey),Item("Teal", R.color.teal_200),)
val list4: MutableList<Item> = arrayListOf(Item("Red", R.color.red),Item("Black", R.color.black),Item("White", R.color.white, true),Item("Blue", R.color.blue),Item("Purple", R.color.purple_200),Item("Green", R.color.green),)

fun getList(code: Int): MutableList<Item> {
    return when (code) {
        0 -> list0
        1 -> list1
        2 -> list2
        3 -> list3
        4 -> list4
        else -> arrayListOf()
    }
}
