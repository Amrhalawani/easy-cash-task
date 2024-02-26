

package com.amrh.data.competitions.local.db.di

import android.content.Context
import androidx.room.Room
import com.amrh.data.competitions.local.db.CompetitionsDao
import com.amrh.data.competitions.local.db.CompetitionsDatabase
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
    fun providesCompetitionsDatabase(
        @ApplicationContext context: Context,
    ): CompetitionsDatabase = Room.databaseBuilder(
        context,
        CompetitionsDatabase::class.java,
        "comp_db"
    ).build()
}



@Module
@InstallIn(SingletonComponent::class)
object DaosModule {
    @Provides
    fun providesCompetitionsDao(
        database: CompetitionsDatabase,
    ): CompetitionsDao = database.CompetitionsDao()

}

