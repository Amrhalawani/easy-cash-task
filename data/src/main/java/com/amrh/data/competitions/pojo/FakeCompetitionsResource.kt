package com.amrh.data.competitions.pojo


fun FakeCompResource(
    id: Int,
    isFavorite: Boolean = false
) = CompetitionsItem(
    area = Area(code = "", flag = "null", name = "null", id = 123),
    lastUpdated = "",
    code = "null",
    currentSeason = CurrentSeason(),
    name = "null",
    id = id,
    numberOfAvailableSeasons = null,
    type = null,
    emblem = "null",
    plan = null

)

