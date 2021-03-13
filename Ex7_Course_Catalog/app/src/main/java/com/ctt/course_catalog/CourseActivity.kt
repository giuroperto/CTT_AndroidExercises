package com.ctt.course_catalog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.view.menu.MenuView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.viewpager.widget.ViewPager
import com.ctt.course_catalog.model.Course
import com.google.android.material.tabs.TabLayout

class CourseActivity : AppCompatActivity() {

    private lateinit var courseData: Course
    private val viewModel: ItemViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course)

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val viewPager = findViewById<ViewPager>(R.id.viewPager)

        courseData = intent.extras?.get("COURSE") as Course

        setSelectedCourse(courseData)

        viewPager.adapter = PageAdapter(supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager)
    }

    fun setSelectedCourse(course: Course) {
        viewModel.changeCourse(course)
    }

}
