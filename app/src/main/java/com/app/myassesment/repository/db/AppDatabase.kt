package com.kotlin.mvvm.repository.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.myassesment.model.profile.ProfileRecordResponse
import com.app.myassesment.repository.db.profiles.ProfileRecordDao

/**
 * Created by Avdhesh Kumar on 05,Sept,2020
 */

/**
 * App Database
 * Define all entities and access doa's here/ Each entity is a table.
 */
@Database(entities = [ProfileRecordResponse.Result::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    /**
     * Get DAO's
     */

    abstract fun profileRecordDao(): ProfileRecordDao

}