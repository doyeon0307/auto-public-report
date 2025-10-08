package com.dokarun.autoreportapp.ui.di

import android.content.Context
import androidx.room.Room
import com.dokarun.autoreportapp.ui.data.AppDatabase
import com.dokarun.autoreportapp.ui.data.ReportDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(
        @ApplicationContext context: Context,
    ): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "auto_report_database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideReportDao(database: AppDatabase): ReportDao {
        return database.reportDao()
    }

}