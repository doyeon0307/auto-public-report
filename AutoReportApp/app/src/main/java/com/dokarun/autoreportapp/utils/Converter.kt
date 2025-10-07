package com.dokarun.autoreportapp.utils

import android.net.Uri
import androidx.room.TypeConverter
import androidx.core.net.toUri

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

}