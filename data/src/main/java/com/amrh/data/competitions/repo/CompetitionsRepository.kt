package com.amrh.data.competitions.repo

import com.amrh.data.competitions.local.LocalCompetitionsDataSource
import com.amrh.data.competitions.pojo.CompetitionsItem
import com.amrh.data.competitions.pojo.CompetitionsRes
import com.amrh.data.competitions.remote.RemoteCompetitionsDataSource
import com.amrh.data.competitions.remote.Res
import com.amrh.data.competitions.remote.UNKNOWN_HOST_EXCEPTION
import com.amrh.data.competitions.remote.flowAsResult
import com.amrh.data.competitions.remote.safeApiCall
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
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


    override suspend fun getCompetitions(): Res<CompetitionsRes> {
        val response = safeApiCall {
            remoteDS.fetchCompetitions()
        }

        if (isUnknownHostException(response)) {
            // Handle network error by returning competitions from local storage
            val competitions = localDS.selectAllCompetition()
            return Res.Success(CompetitionsRes(competitions = competitions.first()))
        } else if (response is Res.Success) {
            response.data.let { localDS.addAllCompetition(it.competitions) }
        }

        return response
    }


    fun isUnknownHostException(response: Res<Any>): Boolean {
        return response is Res.Failure && response.exception.toString()
            .contains(UNKNOWN_HOST_EXCEPTION)
    }

    override fun addCompetitionItem(item: CompetitionsItem) {
        return localDS.addCompetition(item)
    }

    override fun deleteCompetition(item: CompetitionsItem) {
        return localDS.deleteCompetition(item)
    }

}