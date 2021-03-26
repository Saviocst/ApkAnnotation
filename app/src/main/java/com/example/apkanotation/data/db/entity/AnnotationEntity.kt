package com.example.apkanotation.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "annotation")
data class AnnotationEntity (
        @PrimaryKey(autoGenerate = true)
        val id: Long = 0,
        val name: String,
        val annotation: String
        )