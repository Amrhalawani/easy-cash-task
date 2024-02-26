package com.amrh.data.competitions.local.db

import androidx.room.TypeConverter
import com.amrh.data.competitions.pojo.Area
import com.amrh.data.competitions.pojo.CompetitionsItem
import com.amrh.data.competitions.pojo.CurrentSeason
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

object Converters {


    @TypeConverter
    @JvmStatic
    fun areaToString(item: Area?): String? {
        if (item == null) {
            return null
        }
        return Gson().toJson(item)
    }

    @TypeConverter
    @JvmStatic
    fun stringToArea(value: String?): Area? {
        if (value == null) {
            return null
        }
        val type: Type = object : TypeToken<Area?>() {}.type
        return Gson().fromJson(value, type)
    }

    //--------

    @TypeConverter
    @JvmStatic
    fun currentSeasonToString(item: CurrentSeason?): String? {
        if (item == null) {
            return null
        }
        return Gson().toJson(item)
    }

    @TypeConverter
    @JvmStatic
    fun stringToCurrentSeason(value: String?): CurrentSeason? {
        if (value == null) {
            return null
        }
        val type: Type = object : TypeToken<CurrentSeason?>() {}.type
        return Gson().fromJson(value, type)
    }

}