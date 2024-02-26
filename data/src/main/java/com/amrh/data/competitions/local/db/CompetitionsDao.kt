package com.amrh.data.competitions.local.db

import androidx.room.*
import com.amrh.data.competitions.pojo.CompetitionsItem
import kotlinx.coroutines.flow.Flow

@Dao
interface CompetitionsDao {

    @Query("SELECT * FROM `CompetitionsItem` ")
    fun selectAllCompetition(): Flow<List<CompetitionsItem>>

    @Query("SELECT * FROM `CompetitionsItem` where id=:compId")
    fun selectCompetitions(compId: String): Flow<CompetitionsItem>

    @Query("SELECT id FROM `CompetitionsItem`")
    fun selectCompetitionsIDs(): Flow<List<Int>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCompetition(item: CompetitionsItem)

    @Delete
    fun deleteCompetition(item: CompetitionsItem)

    @Query("DELETE From `CompetitionsItem` where id=:deletedId")
    fun deleteCompetitionById(deletedId: String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCompetitionsList(items: List<CompetitionsItem>)

}