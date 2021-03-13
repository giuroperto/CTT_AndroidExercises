package com.ctt.course_catalog

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ctt.course_catalog.R
import com.ctt.course_catalog.model.Course
import com.ctt.course_catalog.model.Subject

class SubjectsFragment : Fragment() {

    private val viewModel: ItemViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_subjects, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var selectedCourse = viewModel.selectedCourse

        var subjects: List<Subject> = setSubjects(selectedCourse)

        val rvSubjects = view.findViewById<RecyclerView>(R.id.subjectsList)
        val adapterSubjects = SubjectsAdapter(subjects)
        rvSubjects.adapter = adapterSubjects
        rvSubjects.layoutManager = LinearLayoutManager(requireContext())
    }

    fun setSubjects(course: Course) : List<Subject> {
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
            Subject(name= "Disciplina 10", desc= "Descricao da disciplina 10", image= subjectDrawable, studyTime= "10h", course = "Engenharia da Computacao"),
        )

        return when(course.name) {
            "Engenharia Civil" -> subjectsCivil
            "Engenharia da Computacao" -> subjectsComputacao
            else -> subjectsCivil
        }
    }

}