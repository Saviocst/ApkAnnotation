package com.example.apkanotation.data.db.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "annotation")
data class AnnotationEntity (
        @PrimaryKey(autoGenerate = true)
        val id: Long = 0,
        val name: String,
        val annotation: String
        ) : Parcelable