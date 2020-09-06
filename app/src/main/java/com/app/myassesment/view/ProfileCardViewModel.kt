package com.app.myassesment.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.app.myassesment.model.profile.ProfileRecordResponse
import com.app.myassesment.repository.api.network.Resource
import com.app.myassesment.repository.repo.ProfileRepository
import javax.inject.Inject

class ProfileCardViewModel @Inject constructor(
    private val profileRepository: ProfileRepository
) : ViewModel() {


    fun getProfiles(): LiveData<Resource<List<ProfileRecordResponse.Result>?>> {
        return profileRepository.getProfiles()
    }
}
