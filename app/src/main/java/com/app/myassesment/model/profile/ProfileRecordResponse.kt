package com.app.myassesment.model.profile


import android.annotation.SuppressLint
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@SuppressLint("ParcelCreator")
@Parcelize
data class ProfileRecordResponse(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")

    var results: List<Result>
) : Parcelable {
    @SuppressLint("ParcelCreator")
    @Parcelize
    data class Info(
        @SerializedName("page")
        val page: Int, // 1
        @SerializedName("results")
        val results: Int, // 5
        @SerializedName("seed")
        val seed: String, // 25160a4d38ff1142
        @SerializedName("version")
        val version: String // 1.3
    ) : Parcelable

    @SuppressLint("ParcelCreator")
    @Parcelize
    @Entity(tableName = "profile_record_table")
    class Result(
        @PrimaryKey(autoGenerate = true)
        var uId:Int=0,

        @SerializedName("cell")
        var cell: String?=null, // 0178-6000657
        @Embedded
        @SerializedName("dob")
        var dob: Dob?=null,
        @SerializedName("email")
        var email: String?=null, // martin.kirst@example.com
        @SerializedName("gender")
        var gender: String?=null, // male

        @Embedded
        @SerializedName("id")
        var id: Id?=null,

        var isConnect:Boolean=false,
        var isSaved:Boolean=false,



        @Ignore
        @SerializedName("location")
        var location: Location?=null,

        @Ignore
        @SerializedName("login")
        var login: Login?=null,

        @Embedded
        @SerializedName("name")
        var name: Name?=null,
        @SerializedName("nat")
        var nat: String?=null, // DE
        @SerializedName("phone")
        var phone: String?=null, // 0711-3502149

        @Embedded
        @SerializedName("picture")
        var picture: Picture?=null,

        @Ignore
        @SerializedName("registered")
        var registered: Registered?=null
    ) : Parcelable {

        @SuppressLint("ParcelCreator")
        @Parcelize
        data class Dob(
            @SerializedName("age")
            val age: Int, // 64
            @SerializedName("date")
            val date: String // 1956-11-29T07:55:25.657Z
        ) : Parcelable

        @SuppressLint("ParcelCreator")
        @Parcelize
        data class Id(
            @SerializedName("name")
            val name: String,
            @SerializedName("value")
            val value: String? // null
        ) : Parcelable

        @SuppressLint("ParcelCreator")
        @Parcelize
        data class Location(
            @SerializedName("city")
            val city: String, // Schönau
            @SerializedName("coordinates")
            val coordinates: Coordinates,
            @SerializedName("country")
            val country: String, // Germany
            @SerializedName("postcode")
            val postcode: Int, // 75817
            @SerializedName("state")
            val state: String, // Bayern
            @SerializedName("street")
            val street: Street,
            @SerializedName("timezone")
            val timezone: Timezone
        ) : Parcelable {
            @SuppressLint("ParcelCreator")
            @Parcelize
            data class Coordinates(
                @SerializedName("latitude")
                val latitude: String, // -44.3713
                @SerializedName("longitude")
                val longitude: String // -68.8131
            ) : Parcelable

            @SuppressLint("ParcelCreator")
            @Parcelize
            data class Street(
                @SerializedName("name")
                val name: String, // Fasanenweg
                @SerializedName("number")
                val number: Int // 5419
            ) : Parcelable

            @SuppressLint("ParcelCreator")
            @Parcelize
            data class Timezone(
                @SerializedName("description")
                val description: String, // Kabul
                @SerializedName("offset")
                val offset: String // +4:30
            ) : Parcelable
        }

        @SuppressLint("ParcelCreator")
        @Parcelize
        data class Login(
            @SerializedName("md5")
            val md5: String, // 5d4df57f168b67efaec5d4be871b842e
            @SerializedName("password")
            val password: String, // witch
            @SerializedName("salt")
            val salt: String, // r5LeAJRV
            @SerializedName("sha1")
            val sha1: String, // b380bdd89a66dc3e9432acafee6a73af72ac8ab0
            @SerializedName("sha256")
            val sha256: String, // e321de40facd71383e4ec88385f9a559d3862fce6be9d1eb763833628aaefbb6
            @SerializedName("username")
            val username: String, // sadbear424
            @SerializedName("uuid")
            val uuid: String // a6a84c1b-4e91-469b-8fb0-53bfb1348032
        ) : Parcelable

        @SuppressLint("ParcelCreator")
        @Parcelize
        data class Name(
            @SerializedName("first")
            val first: String, // Martin
            @SerializedName("last")
            val last: String, // Kirst
            @SerializedName("title")
            val title: String // Mr
        ) : Parcelable

        @SuppressLint("ParcelCreator")
        @Parcelize
        data class Picture(
            @SerializedName("large")
            val large: String, // https://randomuser.me/api/portraits/men/97.jpg
            @SerializedName("medium")
            val medium: String, // https://randomuser.me/api/portraits/med/men/97.jpg
            @SerializedName("thumbnail")
            val thumbnail: String // https://randomuser.me/api/portraits/thumb/men/97.jpg
        ) : Parcelable

        @SuppressLint("ParcelCreator")
        @Parcelize
        data class Registered(
            @SerializedName("age")
            val age: Int, // 5
            @SerializedName("date")
            val date: String // 2015-01-27T15:27:42.942Z
        ) : Parcelable
    }
}