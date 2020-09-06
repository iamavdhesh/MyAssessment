package com.app.myassesment.view

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.myassesment.R
import com.app.myassesment.inflate
import com.app.myassesment.model.profile.ProfileRecordResponse
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.row_profile_view.view.*

/**
 * The Profiles adapter to show the profile in a list.
 */
class ProfilesAdapter : RecyclerView.Adapter<ProfilesAdapter.ProfileHolder>() {

     var listener:OnItemClickedListener?=null
        get() = field
        set(value) {
            field = value
        }

    interface OnItemClickedListener {

        fun onItemClicked(position: Int,view: View,result: ProfileRecordResponse.Result)

    }

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
    override fun onBindViewHolder(profileHolder: ProfileHolder, position: Int) {
        profileHolder.bind(profiles[position])
    }

    /**
     * Number of items in the list to display
     */
    override fun getItemCount() = profiles.size

    /**
     * View Holder Pattern
     */
     inner class ProfileHolder(itemView: View) : RecyclerView.ViewHolder(itemView),View.OnClickListener {

        /**
         * Binds the UI with the data and handles clicks
         */
        fun bind(result: ProfileRecordResponse.Result){

/*
            tvConnectStatus
            tvProfileLocation
            tvProfileStatus
            tvProfileOccupation
            tvProfiledesc
            tvProfileDOB*/
            itemView?. tvProfileName.text = result.id?.name?:""
            itemView?. tvProfileDOB.text = result.dob?.date?:""
            itemView?. tvProfileLocation.text = result.location?.country?:""

            Glide.with(itemView.context)
                .load(result.picture?.thumbnail)
                .apply(
                    RequestOptions()
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.ic_launcher_background)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                )
                .into(itemView?.ivUserProfile)


            itemView?.tvBtnViewDetails.setOnClickListener(this)
            itemView?.tvBtnCall.setOnClickListener(this)
            itemView?.tvBtnMail.setOnClickListener(this)

        }
        override fun onClick(p0: View?) {
            listener?.onItemClicked(adapterPosition,p0!!,result = profiles[adapterPosition])

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