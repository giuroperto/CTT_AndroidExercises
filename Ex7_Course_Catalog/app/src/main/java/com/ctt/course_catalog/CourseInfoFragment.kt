package com.ctt.course_catalog

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.ctt.course_catalog.MainActivity.Companion.civilCourse
import com.ctt.course_catalog.model.Course

class CourseInfoFragment : Fragment() {

    private lateinit var txtCourseTitle : TextView
    private lateinit var txtCourseDesc : TextView
    private lateinit var courseData : Course
    private val viewModel: ItemViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_course_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        txtCourseTitle = view.findViewById(R.id.txtCourseTitle)
        txtCourseDesc = view.findViewById(R.id.txtCourseDesc)

        courseData = viewModel.selectedCourse

        txtCourseTitle.text = courseData.name
        txtCourseDesc.text = courseData.desc

    }
}
