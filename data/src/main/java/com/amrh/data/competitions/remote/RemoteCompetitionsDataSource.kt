package com.amrh.data.competitions.remote

import com.amrh.data.competitions.pojo.CompetitionsRes
import javax.inject.Inject

class RemoteCompetitionsDataSource @Inject constructor(private val apiClient: ApiClient) {
    suspend fun fetchCompetitions(): CompetitionsRes {
        return apiClient.getCompetitions()
    }
}