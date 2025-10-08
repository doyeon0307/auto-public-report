package com.dokarun.autoreportapp.ui.data

import android.net.Uri
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dokarun.autoreportapp.ui.component.ReportStatus
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Entity
data class Report(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "address") val address: String?,
    @ColumnInfo(name = "detailAddress") val detailAddress: String?,
    @ColumnInfo(name = "uri_list") val uriList: List<Uri>?,
    @ColumnInfo(name = "date_time") val dateTime: String = getCurrentDateTime(),
    @ColumnInfo(name = "status") val status: ReportStatus = ReportStatus.PENDING,
)

private fun getCurrentDateTime(): String {
    val dateFormat = SimpleDateFormat("yyyy.MM.dd HH:mm", Locale.getDefault())
    return dateFormat.format(Date())
}