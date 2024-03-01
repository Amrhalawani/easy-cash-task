package com.amrh.data.competitions.local.db

import androidx.room.TypeConverter
import com.amrh.data.competitions.pojo.Area
import com.amrh.data.competitions.pojo.CompetitionsItem
import com.amrh.data.competitions.pojo.CurrentSeason
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
object Converters {

    private val gson: Gson = Gson()

    @TypeConverter
    @JvmStatic
    fun areaToString(item: Area?): String? {
        return item?.let { gson.toJson(it) }
    }

    @TypeConverter
    @JvmStatic
    fun stringToArea(value: String?): Area? {
        return value?.let { gson.fromJson(it, Area::class.java) }
    }

    @TypeConverter
    @JvmStatic
    fun currentSeasonToString(item: CurrentSeason?): String? {
        return item?.let { gson.toJson(it) }
    }

    @TypeConverter
    @JvmStatic
    fun stringToCurrentSeason(value: String?): CurrentSeason? {
        return value?.let { gson.fromJson(it, CurrentSeason::class.java) }
    }
}