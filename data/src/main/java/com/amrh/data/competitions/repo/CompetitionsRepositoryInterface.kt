package com.amrh.data.competitions.repo

import com.amrh.data.competitions.pojo.CompetitionsItem
import com.amrh.data.competitions.pojo.CompetitionsRes
import com.amrh.data.competitions.remote.Res
import kotlinx.coroutines.flow.Flow

interface CompetitionsRepositoryInterface {

    fun selectAllCompetition(): Flow<List<CompetitionsItem>>
    fun selectCompetitionsIDs(): Flow<List<Int>>
    suspend fun getCompetitions(): Res<CompetitionsRes>
    fun addCompetitionItem(item: CompetitionsItem)
    fun deleteCompetition(item: CompetitionsItem)

}