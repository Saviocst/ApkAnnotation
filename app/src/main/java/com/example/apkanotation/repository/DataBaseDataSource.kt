package com.example.apkanotation.repository

import androidx.lifecycle.LiveData
import com.example.apkanotation.data.db.dao.AnnotationDAO
import com.example.apkanotation.data.db.entity.AnnotationEntity

class DataBaseDataSource(
        private val annotationDAO: AnnotationDAO

) : AnnotationRepository {
    override suspend fun insertAnnotation(name: String, annotation: String): Long {
        val annotationSv = AnnotationEntity(
                name = name,
                annotation = annotation
        )

         return annotationDAO.insert(annotationSv)
    }

    override suspend fun updateAnnotation(id: Long, name: String, annotation: String) {

        val annotationSv = AnnotationEntity(
                id = id,
                name = name,
                annotation = annotation
        )

        annotationDAO.update(annotationSv)
    }

    override suspend fun deleteAnnotation(id: Long) {

        annotationDAO.delete(id)
    }

    override suspend fun deleteAllAnnotation() {

        annotationDAO.deleteAll()
    }

    override suspend fun getAllAnnotation(): List<AnnotationEntity> {

        return annotationDAO.getAll()
    }

    // Fim video 5 -> 6
}