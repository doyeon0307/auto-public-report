package com.dokarun.autoreportapp.ui.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dokarun.autoreportapp.utils.Converter

@Database(entities = [Report::class], version = 3)
@TypeConverters(Converter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun reportDao(): ReportDao
}