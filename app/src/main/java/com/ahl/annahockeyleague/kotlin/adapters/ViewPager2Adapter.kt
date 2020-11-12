package com.ahl.annahockeyleague.kotlin.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPager2Adapter(private val fragmentList : List<Fragment>, fragment : Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
            if(fragmentList.isEmpty()){
                return 0
            }
            return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {

       return when(position){
            0 ->  fragmentList[position]
            1 ->  fragmentList[position]
            else -> null!!
        }

    }

    fun getTitleList(position : Int) : String = arrayListOf("Men", "Women")[position]


}