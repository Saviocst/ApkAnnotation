package com.example.apkanotation.repository

import androidx.lifecycle.LiveData
import com.example.apkanotation.data.db.entity.AnnotationEntity

interface AnnotationRepository {

    suspend fun insertAnnotation(name: String, annotation: String): Long

    suspend fun updateAnnotation(id: Long, name: String, annotation: String)

    suspend fun deleteAnnotation(id: Long)

    suspend fun deleteAllAnnotation()

    suspend fun getAllAnnotation(): LiveData<List<AnnotationEntity>>
}