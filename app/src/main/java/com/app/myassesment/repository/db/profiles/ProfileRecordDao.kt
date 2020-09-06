package com.app.myassesment.repository.db.profiles

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.myassesment.model.profile.ProfileRecordResponse

/**
 * Created by Avdhesh Kumar on 05,Sept,2020
 */

/**
 * Abstracts access to the profile database
 */
@Dao
interface ProfileRecordDao {

    /**
     * Insert articles into the database
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProfiles(list: List<ProfileRecordResponse.Result>): List<Long>

    /**
     * Get all the articles from database
     */
    @Query("SELECT * FROM profile_record_table")
    fun getProfilesRecords(): LiveData<List<ProfileRecordResponse.Result>>

    @Query("DELETE FROM profile_record_table")
    abstract fun deleteAllProfiles()
}