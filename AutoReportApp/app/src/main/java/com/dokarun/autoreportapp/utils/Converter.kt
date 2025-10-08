package com.dokarun.autoreportapp.utils

import android.net.Uri
import androidx.room.TypeConverter
import androidx.core.net.toUri
import com.dokarun.autoreportapp.ui.component.ReportStatus

class Converter {

    @TypeConverter
    fun fromUriList(uriList: List<Uri>?): String? {
        return uriList?.joinToString(",") { it.toString() }
    }

    @TypeConverter
    fun toUriList(uriString: String?): List<Uri>? {
        return uriString?.split(",")
            ?.filter { it.isNotEmpty() }
            ?.map { it.toUri() }
    }

    @TypeConverter
    fun fromReportStatus(value: ReportStatus): String {
        return value.name
    }

    @TypeConverter
    fun toReportStatus(value: String): ReportStatus {
        return ReportStatus.valueOf(value)
    }

}