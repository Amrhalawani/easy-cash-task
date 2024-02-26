package com.amrh.data.competitions.local

import com.amrh.data.competitions.local.db.CompetitionsDao
import com.amrh.data.competitions.pojo.CompetitionsItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalCompetitionsDataSource @Inject constructor(private val competitionsDao: CompetitionsDao) {

     fun selectAllCompetition(): Flow<List<CompetitionsItem>> {
        return competitionsDao.selectAllCompetition()
    }

    fun selectCompetitionsIDs(): Flow<List<Int>> {
        return competitionsDao.selectCompetitionsIDs()
    }

     fun addCompetition(item: CompetitionsItem) {
        competitionsDao.insertCompetition(item)
    }

     fun deleteCompetition(item: CompetitionsItem){
        competitionsDao.deleteCompetition(item)
    }
}