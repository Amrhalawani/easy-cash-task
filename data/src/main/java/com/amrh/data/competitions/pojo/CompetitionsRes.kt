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
	val area: Area? = null,

	@field:SerializedName("lastUpdated")
	val lastUpdated: String? = null,

	@field:SerializedName("code")
	val code: String? = null,

	@field:SerializedName("currentSeason")
	val currentSeason: CurrentSeason? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@PrimaryKey
	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("numberOfAvailableSeasons")
	val numberOfAvailableSeasons: Int? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("emblem")
	val emblem: String? = null,

	@field:SerializedName("plan")
	val plan: String? = null
) : Parcelable

@Parcelize
@Entity
data class Area(

	@field:SerializedName("code")
	val code: String? = null,

	@field:SerializedName("flag")
	val flag: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
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
