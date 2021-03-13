package com.ctt.course_catalog

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ctt.course_catalog.MainActivity.Companion.civilCourse
import com.ctt.course_catalog.model.Course

class ItemViewModel: ViewModel() {

    var selectedCourse: Course = civilCourse

    fun changeCourse(course: Course) {
        selectedCourse = course
    }
}
