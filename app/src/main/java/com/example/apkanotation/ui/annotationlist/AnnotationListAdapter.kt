package com.example.apkanotation.ui.annotationlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apkanotation.R
import com.example.apkanotation.data.db.entity.AnnotationEntity
import kotlinx.android.synthetic.main.annotation_item.view.*

class AnnotationListAdapter(private val annotations: List<AnnotationEntity>) : RecyclerView.Adapter<AnnotationListAdapter.AnnotationListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnnotationListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.annotation_item, parent, false)
        return AnnotationListViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnnotationListViewHolder, position: Int) {
        holder.bindView(annotations[position])
    }

    override fun getItemCount() = annotations.size

     class AnnotationListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

         private val textViewRemember: TextView = itemView.text_remember_sv
         private val textViewAnnotation: TextView = itemView.text_annotation_sv

         fun bindView(annotation: AnnotationEntity){
             textViewRemember.text = annotation.name
             textViewAnnotation.text = annotation.annotation
         }
    }
}