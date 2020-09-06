package com.app.myassesment.view

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.myassesment.R
import com.app.myassesment.inflate
import com.app.myassesment.model.profile.ProfileRecordResponse

/**
 * The Profiles adapter to show the profile in a list.
 */
class ProfilesAdapter(
    private val listener: (ProfileRecordResponse.Result) -> Unit
) : RecyclerView.Adapter<ProfilesAdapter.ProfileHolder>() {

    /**
     * List of profiles
     */
    private var profiles: List<ProfileRecordResponse.Result> = emptyList()

    /**
     * Inflate the view
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ProfileHolder(parent.inflate(R.layout.row_profile_view))

    /**
     * Bind the view with the data
     */
    override fun onBindViewHolder(profileHolder: ProfileHolder, position: Int) =
        profileHolder.bind(profiles[position], listener)

    /**
     * Number of items in the list to display
     */
    override fun getItemCount() = profiles.size

    /**
     * View Holder Pattern
     */
    class ProfileHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        /**
         * Binds the UI with the data and handles clicks
         */
        fun bind(result: ProfileRecordResponse.Result, listener: (ProfileRecordResponse.Result) -> Unit) = with(itemView) {
            setOnClickListener { listener(result) }

        }
    }

    /**
     * Swap function to set new data on updating
     */
    fun replaceItems(items: List<ProfileRecordResponse.Result>) {
        profiles = items
        notifyDataSetChanged()
    }
}