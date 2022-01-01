package com.aps.kthalabook.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import java.util.ArrayList


class FragmentAdapter(fragmentActivity: FragmentActivity, list: List<Fragment>) :
    FragmentStateAdapter(fragmentActivity) {
    var list: List<Fragment> = ArrayList()
    override fun createFragment(p: Int): Fragment {
        return list[p]
    }

    override fun getItemCount(): Int {
        return list.size
    }

    init {
        this.list = list
    }
}