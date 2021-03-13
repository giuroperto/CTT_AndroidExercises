package com.ctt.course_catalog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ctt.course_catalog.model.Subject

class SubjectsAdapter(private val subjectsList: List<Subject>) : RecyclerView.Adapter<SubjectsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgSubject: ImageView = view.findViewById(R.id.imgSubj)
        val txtNameSubj: TextView = view.findViewById(R.id.txtTitleSubj)
        val txtDescSubj: TextView = view.findViewById(R.id.txtDescSubj)
        val txtTimeSubj: TextView = view.findViewById(R.id.txtTimeSubj)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectsAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_subject, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: SubjectsAdapter.ViewHolder, position: Int) {
        holder.imgSubject.setImageDrawable(subjectsList[position].image)
        holder.txtNameSubj.text = subjectsList[position].name
        holder.txtDescSubj.text = subjectsList[position].desc
        holder.txtTimeSubj.text = subjectsList[position].studyTime
    }

    override fun getItemCount(): Int = subjectsList.size

}