package com.app.myassesment.repository.api

import androidx.lifecycle.LiveData
import com.app.myassesment.model.profile.ProfileRecordResponse
import com.app.myassesment.repository.api.network.Resource
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by Avdhesh Kumar on 05,Sept,2020
 */

interface ApiServices {

    /*https://randomuser.me/api/?results=5#*/
    @GET("api/")
    fun getProfiles(@Query("results") result:Int): LiveData<Resource<ProfileRecordResponse>>


}
