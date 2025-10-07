package com.dokarun.autoreportapp.ui.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ReportDao {

    @Query("SELECT * FROM report")
    suspend fun getAll(): List<Report>

    @Query("SELECT * FROM report WHERE id = :id")
    suspend fun findById(id: Int): Report?

    @Insert
    suspend fun insert(report: Report)

}