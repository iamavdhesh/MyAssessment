package com.app.myassesment.view

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.myassesment.*
import com.app.myassesment.core.BaseActivity
import com.app.myassesment.model.profile.ProfileRecordResponse
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.empty_layout_.*
import kotlinx.android.synthetic.main.progress_layout_.*

class CardProfilesActivity : BaseActivity<ProfileCardViewModel>() {

    private lateinit var myProfileAdapter: ProfilesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        with(profile_list) {
            setEmptyView(empty_view)
            setProgressView(progress_view)


            myProfileAdapter = ProfilesAdapter()
            myProfileAdapter.listener= object : ProfilesAdapter.OnItemClickedListener {
                override fun onItemClicked(
                    position: Int,
                    view: View,
                    result: ProfileRecordResponse.Result
                ) {


                }

            }
            adapter = myProfileAdapter
            layoutManager =
                LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        }


    }

    override fun onResume() {
        super.onResume()
        getProfiles()

    }

    private fun getProfiles() {

        /*
        * Observing for data change, Cater DB and Network Both
        * */
        viewModel.getProfiles().observe(this) {
            when {
                it.status.isLoading() -> {
                    profile_list.showProgressView()
                }
                it.status.isSuccessful() -> {
                    it.load(profile_list) {
                        // Update the UI as the data has changed
                        it?.let { myProfileAdapter.replaceItems(it) }
                    }
                }
                it.status.isError() -> {
                    if (it.errorMessage != null)
                        showMessage(it.errorMessage.toString())
                }
            }
        }

    }

    val viewModel: ProfileCardViewModel by lazy {
        getViewModel()
    }


}