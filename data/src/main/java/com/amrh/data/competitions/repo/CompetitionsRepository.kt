package com.amrh.data.competitions.repo

import com.amrh.data.competitions.local.LocalCompetitionsDataSource
import com.amrh.data.competitions.pojo.CompetitionsItem
import com.amrh.data.competitions.pojo.CompetitionsRes
import com.amrh.data.competitions.remote.RemoteCompetitionsDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CompetitionsRepository @Inject constructor(
    private val localDS: LocalCompetitionsDataSource,
    private val remoteDS: RemoteCompetitionsDataSource
) : CompetitionsRepositoryInterface {


    override fun selectAllCompetition(): Flow<List<CompetitionsItem>> {
        return localDS.selectAllCompetition()
    }

    override fun selectCompetitionsIDs(): Flow<List<Int>> {
        return localDS.selectCompetitionsIDs()
    }

    override suspend fun getCompetitions(): CompetitionsRes {
        return remoteDS.fetchCompetitions()
    }

    override fun addCompetitionItem(item: CompetitionsItem) {
        return localDS.addCompetition(item)
    }

    override fun deleteCompetition(item: CompetitionsItem) {
        return localDS.deleteCompetition(item)
    }

}