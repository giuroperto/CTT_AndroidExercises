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

        val subjectDrawable: Drawable = resources.getDrawable(R.drawable.ic_online_course)

        val subjectsCivil : List<Subject> = listOf(
            Subject(name= "Disciplina 1", desc= "Descricao da disciplina 1", image= subjectDrawable, studyTime= "1h", course = "Engenharia Civil"),
            Subject(name= "Disciplina 2", desc= "Descricao da disciplina 2", image= subjectDrawable, studyTime= "2h", course = "Engenharia Civil"),
            Subject(name= "Disciplina 3", desc= "Descricao da disciplina 3", image= subjectDrawable, studyTime= "3h", course = "Engenharia Civil"),
            Subject(name= "Disciplina 4", desc= "Descricao da disciplina 4", image= subjectDrawable, studyTime= "4h", course = "Engenharia Civil"),
            Subject(name= "Disciplina 5", desc= "Descricao da disciplina 5", image= subjectDrawable, studyTime= "5h", course = "Engenharia Civil"),
            Subject(name= "Disciplina 6", desc= "Descricao da disciplina 6", image= subjectDrawable, studyTime= "6h", course = "Engenharia Civil"),
            Subject(name= "Disciplina 7", desc= "Descricao da disciplina 7", image= subjectDrawable, studyTime= "7h", course = "Engenharia Civil"),
            Subject(name= "Disciplina 8", desc= "Descricao da disciplina 8", image= subjectDrawable, studyTime= "8h", course = "Engenharia Civil"),
            Subject(name= "Disciplina 9", desc= "Descricao da disciplina 9", image= subjectDrawable, studyTime= "9h", course = "Engenharia Civil"),
        )
        val subjectsComputacao : List<Subject> = listOf(
            Subject(name= "Disciplina 1", desc= "Descricao da disciplina 1", image= subjectDrawable, studyTime= "1h", course = "Engenharia da Computacao"),
            Subject(name= "Disciplina 2", desc= "Descricao da disciplina 2", image= subjectDrawable, studyTime= "2h", course = "Engenharia da Computacao"),
            Subject(name= "Disciplina 3", desc= "Descricao da disciplina 3", image= subjectDrawable, studyTime= "3h", course = "Engenharia da Computacao"),
            Subject(name= "Disciplina 4", desc= "Descricao da disciplina 4", image= subjectDrawable, studyTime= "4h", course = "Engenharia da Computacao"),
            Subject(name= "Disciplina 5", desc= "Descricao da disciplina 5", image= subjectDrawable, studyTime= "5h", course = "Engenharia da Computacao"),
            Subject(name= "Disciplina 6", desc= "Descricao da disciplina 6", image= subjectDrawable, studyTime= "6h", course = "Engenharia da Computacao"),
            Subject(name= "Disciplina 7", desc= "Descricao da disciplina 7", image= subjectDrawable, studyTime= "7h", course = "Engenharia da Computacao"),
            Subject(name= "Disciplina 8", desc= "Descricao da disciplina 8", image= subjectDrawable, studyTime= "8h", course = "Engenharia da Computacao"),
            Subject(name= "Disciplina 9", desc= "Descricao da disciplina 9", image= subjectDrawable, studyTime= "9h", course = "Engenharia da Computacao"),
        )

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
