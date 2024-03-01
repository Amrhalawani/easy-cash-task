package com.amrh.data.competitions.pojo

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Parcelize
data class CompetitionsRes(

	@field:SerializedName("count")
	val count: Int? = null,

	@field:SerializedName("competitions")
	val competitions: List<CompetitionsItem>? = null,

	@field:SerializedName("filters")
	val filters: Filters? = null
) : Parcelable

@Parcelize
@Entity
data class CompetitionsItem(

	@field:SerializedName("area")
	var area: Area? = null,

	@field:SerializedName("lastUpdated")
	var lastUpdated: String? = null,

	@field:SerializedName("code")
	var code: String? = null,

	@field:SerializedName("currentSeason")
	var currentSeason: CurrentSeason? = null,

	@field:SerializedName("name")
	var name: String? = null,

	@PrimaryKey
	@field:SerializedName("id")
	var id: Int = 0,

	@field:SerializedName("numberOfAvailableSeasons")
	var numberOfAvailableSeasons: Int? = null,

	@field:SerializedName("type")
	var type: String? = null,

	@field:SerializedName("emblem")
	var emblem: String? = null,

	@field:SerializedName("plan")
	var plan: String? = null
) : Parcelable

@Parcelize

data class Area(

	@field:SerializedName("code")
	var code: String? = null,

	@field:SerializedName("flag")
	var flag: String? = null,

	@field:SerializedName("name")
	var name: String? = null,

	@field:SerializedName("id")
	var id: Int? = null
) : Parcelable

@Parcelize
data class Winner(

	@field:SerializedName("venue")
	val venue: String? = null,

	@field:SerializedName("lastUpdated")
	val lastUpdated: String? = null,

	@field:SerializedName("website")
	val website: String? = null,

	@field:SerializedName("address")
	val address: String? = null,

	@field:SerializedName("clubColors")
	val clubColors: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("tla")
	val tla: String? = null,

	@field:SerializedName("founded")
	val founded: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("shortName")
	val shortName: String? = null,

	@field:SerializedName("crest")
	val crest: String? = null
) : Parcelable

@Parcelize
@Entity
data class CurrentSeason(

	@field:SerializedName("winner")
	val winner: String? = null,

	@field:SerializedName("currentMatchday")
	val currentMatchday: Int? = null,

	@field:SerializedName("endDate")
	val endDate: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("startDate")
	val startDate: String? = null
) : Parcelable

@Parcelize
data class Filters(

	@field:SerializedName("client")
	val client: String? = null
) : Parcelable
