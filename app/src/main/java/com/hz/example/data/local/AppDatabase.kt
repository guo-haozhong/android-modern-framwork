package com.hz.example.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hz.example.data.model.DataModel

@Database(entities = [DataModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dataDao(): DataDao
}