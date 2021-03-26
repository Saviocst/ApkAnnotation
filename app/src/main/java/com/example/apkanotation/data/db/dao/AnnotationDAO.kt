package com.example.apkanotation.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.apkanotation.data.db.entity.AnnotationEntity

@Dao
interface AnnotationDAO {

    @Insert
    suspend fun insert(annotation: AnnotationEntity): Long

    @Update
    suspend fun update(annotation: AnnotationEntity)

    @Query("DELETE FROM annotation WHERE id = :id")
    suspend fun delete(id: Long)

    @Query("DELETE FROM annotation")
    suspend fun deleteAll()

    @Query("SELECT * FROM annotation")
    fun getAll(): LiveData<List<AnnotationEntity>>

}