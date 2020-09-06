package com.app.myassesment.repository.repo

import android.content.Context
import androidx.lifecycle.LiveData
import com.app.myassesment.core.AppExecutors
import com.app.myassesment.model.profile.ProfileRecordResponse
import com.app.myassesment.repository.api.ApiServices
import com.app.myassesment.repository.api.network.NetworkAndDBBoundResource
import com.app.myassesment.repository.api.network.Resource
import com.app.myassesment.repository.db.profiles.ProfileRecordDao
import com.app.myassesment.utils.Utils
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Avdhesh Kumar on 05,Sept,2020
 */

/**
 * Repository abstracts the logic of fetching the data and persisting it for
 * offline. They are the data source as the single source of truth.
 *
 */

@Singleton
class ProfileRepository @Inject constructor(
    private val profileRecordDao: ProfileRecordDao,
    private val apiServices: ApiServices, private val context: Context,
    private val appExecutors: AppExecutors = AppExecutors()
) {

    /**
     * Fetch the profile from database if exist else fetch from web
     * and persist them in the database
     */

    fun getProfiles(): LiveData<Resource<List<ProfileRecordResponse.Result>?>> {


        return object :
            NetworkAndDBBoundResource<List<ProfileRecordResponse.Result>, ProfileRecordResponse>(
                appExecutors
            ) {
            override fun saveCallResult(item: ProfileRecordResponse) {
                if (!item.results.isEmpty()) {
                    profileRecordDao.deleteAllProfiles()
                    profileRecordDao.insertProfiles(item.results)
                }
            }

            override fun shouldFetch(data: List<ProfileRecordResponse.Result>?) =
                (Utils.isConnected(context))

            override fun loadFromDb() = profileRecordDao.getProfilesRecords()

            override fun createCall() =
                apiServices.getProfiles()

        }.asLiveData()
    }


}