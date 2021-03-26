package com.example.apkanotation.data.db

import android.content.ContentValues
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.apkanotation.data.db.dao.AnnotationDAO
import com.example.apkanotation.data.db.entity.AnnotationEntity

@Database(entities = [AnnotationEntity::class], version = 1)
abstract class DataBaseSv : RoomDatabase() {

    abstract val annotationDAO: AnnotationDAO

    companion object{
        @Volatile
        private var INSTANCE: DataBaseSv? = null

        fun getInstance(context: Context): DataBaseSv{
            synchronized(this){
                var instance: DataBaseSv? = INSTANCE
                if (instance == null){
                    instance = Room.databaseBuilder(
                            context, DataBaseSv::class.java,
                            "database_sv"
                    ).build()
                }
                return instance
            }
        }
    }
}