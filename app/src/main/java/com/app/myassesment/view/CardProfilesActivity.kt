package com.app.myassesment.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.myassesment.*
import com.app.myassesment.core.BaseActivity
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.empty_layout_.*
import kotlinx.android.synthetic.main.progress_layout_.*

class CardProfilesActivity : BaseActivity<ProfileCardViewModel>() {

    private lateinit var adapter: ProfilesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        profile_list.setEmptyView(empty_view)
        profile_list.setProgressView(progress_view)

        adapter = ProfilesAdapter {
            toast(it.name.toString())
        }
        profile_list.adapter = adapter
        profile_list.layoutManager = LinearLayoutManager(this)

        getProfiles()


    }

    private fun getProfiles() {

        /*
        * Observing for data change, Cater DB and Network Both
        * */
        viewModel?.getProfiles()?.observe(this) {
            when {
                it.status.isLoading() -> {
                    profile_list.showProgressView()
                }
                it.status.isSuccessful() -> {
                    it.load(profile_list) {
                        // Update the UI as the data has changed
                        it?.let { adapter.replaceItems(it) }
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