package com.android.bootcamp_bitirme.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ItunesResult(

	val resultCount : Int,
	val results : List<ItemData>

):Serializable
data class ItemData(
	//Used
	val kind : String,
	@SerializedName(value="collectionName", alternate = ["trackName"])
	val collectionName : String,
	val artworkUrl100 : String,
	@SerializedName("collectionPrice",alternate = ["price","trackPrice"])
	val collectionPrice : Double,
	val artistName : String,
	val releaseDate : String,
	val collectionCensoredName : String,
	val trackCensoredName : String,
	val artistViewUrl : String,
	val collectionViewUrl : String,
	val trackViewUrl : String,
	val previewUrl : String,
	val trackTimeMillis : Long,
	val country : String,
	val currency : String,
	val primaryGenreName : String,

	//software
	val screenshotUrls : List<String>,
	val fileSizeBytes : Long,
	val minimumOsVersion : String,
	@SerializedName("description",alternate = ["longDescription"])
	val description : String,
	val version : String,
	val averageUserRating : Double,
	val userRatingCount : Int


):Serializable
	data class MusicData(

		val wrapperType : String,
		val kind : String,
		val artistId : Int,
		val collectionId : Int,
		val trackId : Int,
		val artistName : String,
		val collectionName : String,
		val trackName : String,
		val collectionCensoredName : String,
		val trackCensoredName : String,
		val artistViewUrl : String,
		val collectionViewUrl : String,
		val trackViewUrl : String,
		val previewUrl : String,
		val artworkUrl30 : String,
		val artworkUrl60 : String,
		val artworkUrl100 : String,
		val collectionPrice : Double,
		val trackPrice : Double,
		val releaseDate : String,
		val collectionExplicitness : String,
		val trackExplicitness : String,
		val discCount : Int,
		val discNumber : Int,
		val trackCount : Int,
		val trackNumber : Int,
		val trackTimeMillis : Int,
		val country : String,
		val currency : String,
		val primaryGenreName : String,
		val isStreamable : Boolean
	):Serializable
	data class SoftwareData (


		val artworkUrl60 : String,
		val artworkUrl512 : String,
		val artworkUrl100 : String,
		val artistViewUrl : String,

		val features : List<String>,
		val supportedDevices : List<String>,
		val advisories : List<String>,
		val isGameCenterEnabled : Boolean,
		val kind : String,

		val trackCensoredName : String,
		val languageCodesISO2A : List<String>,

		val sellerUrl : String,
		val formattedPrice : String,
		val contentAdvisoryRating : String,
		val averageUserRatingForCurrentVersion : Double,
		val userRatingCountForCurrentVersion : Int,

		val trackViewUrl : String,
		val trackContentRating : String,
		val bundleId : String,
		val trackId : Int,
		val trackName : String,
		val releaseDate : String,
		val sellerName : String,
		val primaryGenreName : String,
		val genreIds : List<Int>,
		val isVppDeviceBasedLicensingEnabled : Boolean,
		val currentVersionReleaseDate : String,
		val releaseNotes : String,
		val primaryGenreId : Int,
		val currency : String,
		val version : String,
		val wrapperType : String,

		val artistId : Int,
		val artistName : String,
		val genres : List<String>,
		val price : Int,

	):Serializable
	data class EbookData(
		val ipadScreenshotUrls : List<String>,
		val appletvScreenshotUrls : List<String>,
		val artworkUrl60 : String,
		val artworkUrl512 : String,
		val artworkUrl100 : String,
		val artistViewUrl : String,
		val screenshotUrls : List<String>,
		val features : List<String>,
		val supportedDevices : List<String>,
		val advisories : List<String>,
		val isGameCenterEnabled : Boolean,
		val kind : String,
		val minimumOsVersion : Double,
		val trackCensoredName : String,
		val languageCodesISO2A : List<String>,
		val fileSizeBytes : Int,
		val sellerUrl : String,
		val formattedPrice : String,
		val contentAdvisoryRating : String,
		val averageUserRatingForCurrentVersion : Double,
		val userRatingCountForCurrentVersion : Int,
		val averageUserRating : Double,
		val trackViewUrl : String,
		val trackContentRating : String,
		val bundleId : String,
		val trackId : Int,
		val trackName : String,
		val releaseDate : String,
		val sellerName : String,
		val primaryGenreName : String,
		val genreIds : List<Int>,
		val isVppDeviceBasedLicensingEnabled : Boolean,
		val currentVersionReleaseDate : String,
		val releaseNotes : String,
		val primaryGenreId : Int,
		val currency : String,
		val version : String,
		val wrapperType : String,
		val description : String,
		val artistId : Int,
		val artistName : String,
		val genres : List<String>,
		val price : Int,
		val userRatingCount : Int
	):Serializable
	data class MovieData(
		val wrapperType : String,
		val kind : String,
		val trackId : Int,
		val artistName : String,
		val trackName : String,
		val trackCensoredName : String,
		val trackViewUrl : String,
		val previewUrl : String,
		val artworkUrl30 : String,
		val artworkUrl60 : String,
		val artworkUrl100 : String,
		val collectionPrice : Double,
		val trackPrice : Double,
		val trackRentalPrice : Double,
		val collectionHdPrice : Double,
		val trackHdPrice : Double,
		val trackHdRentalPrice : Double,
		val releaseDate : String,
		val collectionExplicitness : String,
		val trackExplicitness : String,
		val trackTimeMillis : Int,
		val country : String,
		val currency : String,
		val primaryGenreName : String,
		val contentAdvisoryRating : String,
		val shortDescription : String,
		val longDescription : String,
		val hasITunesExtras : Boolean
	):Serializable
