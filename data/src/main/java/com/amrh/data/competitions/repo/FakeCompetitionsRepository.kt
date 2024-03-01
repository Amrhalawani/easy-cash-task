package com.amrh.data.competitions.repo

import com.amrh.data.competitions.pojo.CompetitionsItem
import com.amrh.data.competitions.pojo.CompetitionsRes
import com.amrh.data.competitions.remote.Res
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class FakeCompetitionsRepository() : CompetitionsRepositoryInterface {

    override fun selectAllCompetition(): Flow<List<CompetitionsItem>> {
        return flow {
            listOf<CompetitionsItem>()
        }
    }

    override fun selectCompetitionsIDs(): Flow<List<Int>> {
        return flow {
            listOf<Int>()
        }
    }

    override suspend fun getCompetitions(): Res<CompetitionsRes> {
       return Res.Success(CompetitionsRes())
    }


    override fun addCompetitionItem(item: CompetitionsItem) {}
    override fun deleteCompetition(item: CompetitionsItem) {}
}