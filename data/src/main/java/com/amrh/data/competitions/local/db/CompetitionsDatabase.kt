package com.amrh.data.competitions.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.amrh.data.competitions.pojo.CompetitionsItem

@Database(entities = [CompetitionsItem::class], exportSchema = false, version = 2)
@TypeConverters(Converters::class)
abstract class CompetitionsDatabase : RoomDatabase() {

    abstract fun CompetitionsDao(): CompetitionsDao

}