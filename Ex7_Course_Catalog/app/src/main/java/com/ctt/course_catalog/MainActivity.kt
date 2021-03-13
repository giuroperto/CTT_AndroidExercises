package com.ctt.course_catalog

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import com.ctt.course_catalog.model.Course
import com.ctt.course_catalog.model.Subject

class MainActivity : AppCompatActivity() {

    private lateinit var btnNext : Button

    private lateinit var selectedCourse : Course

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spnCourse: Spinner = findViewById(R.id.spnCourses)
        val coursesList = resources.getStringArray(R.array.courses_list)

        if (spnCourse != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item,
                coursesList
            )
            spnCourse.adapter = adapter
        }

        btnNext = findViewById(R.id.btnNext)

        val coursesInfo = listOf(
            civilCourse,
            comptCourse
        )

        spnCourse.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when (coursesList[position]) {
                    "Engenharia Civil" -> selectedCourse = coursesInfo[0]
                    "Engenharia da Computacao" -> selectedCourse = coursesInfo[1]
                    else -> Log.e("COURSE_ERROR", "Error. You have to choose one of the list")
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Log.e("COURSE_ERROR", "Error. You have to choose one of the list")
            }

        }

        btnNext.setOnClickListener{
            redirect(selectedCourse)
        }
    }

    fun redirect(course: Course) {

        var courseKey = "COURSE"

        val targetActivity = Intent(this, CourseActivity::class.java)
        targetActivity.putExtra(courseKey, course)

        startActivity(targetActivity)

        finish()
    }

    companion object {
        var civilCourse = Course(name =  "Engenharia Civil", desc = "Nesse curso voce ira aprender nocoes basicas de Engenharia Civil com os mais consagrados professores do pais e estara pronto para atuar no mercado em apenas 6 meses!")
        var comptCourse = Course(name = "Engenharia da Computacao", desc = "Esse e o curso mais atual do mercado e apresenta maiores possibilidades de conseguir um emprego antes mesmo de acabar o primeiro ano. Voce tera aula com as maiores referencias de mercado nos 2 anos de curso.")
    }
}
