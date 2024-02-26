package com.amrh.data.competitions.remote

import com.amrh.data.competitions.pojo.CompetitionsRes
import retrofit2.http.*

interface ApiClient {

    @GET(COMPETITIONS_END_POINT)
    suspend fun getCompetitions(): CompetitionsRes

}