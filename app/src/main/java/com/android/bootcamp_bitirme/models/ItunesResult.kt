package com.android.bootcamp_bitirme.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ItunesResult(

	val resultCount : Int,
	val results : List<ItemData>

):Serializable
data class ItemData(
	//Used values
	val kind : String,
	@SerializedName(value="collectionName", alternate = ["trackName"])
	val collectionName : String,
	val artworkUrl100 : String,
	@SerializedName("collectionPrice",alternate = ["price","trackPrice"])
	val collectionPrice : Double,
	val artistName : String,
	val releaseDate : String,
	val trackTimeMillis : Long,
	val primaryGenreName : String,
	val fileSizeBytes : Long,
	@SerializedName("description",alternate = ["longDescription"])
	val description : String,
	val averageUserRating : Float,
	val userRatingCount : Int,
	val currentVersionReleaseDate : String
):Serializable

