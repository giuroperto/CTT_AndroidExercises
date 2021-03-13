package com.ctt.course_catalog

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> CourseInfoFragment()
            1 -> SubjectsFragment()
            else -> CourseInfoFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> "Infos"
            1 -> "Disciplinas"
            else -> super.getPageTitle(position)
        }
    }

}