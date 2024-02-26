package com.amrh.data.competitions.repo

import com.amrh.data.competitions.pojo.CompetitionsItem
import com.amrh.data.competitions.pojo.CompetitionsRes
import kotlinx.coroutines.flow.Flow

interface CompetitionsRepositoryInterface {

    fun selectAllCompetition(): Flow<List<CompetitionsItem>>
    fun selectCompetitionsIDs(): Flow<List<Int>>
    suspend fun getCompetitions(): CompetitionsRes
    fun addCompetitionItem(item: CompetitionsItem)
    fun deleteCompetition(item: CompetitionsItem)

}