package com.himmat.userlistdata.presentation.user_screen.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.himmat.userlistdata.R
import com.himmat.userlistdata.domain.models.Data
import de.hdodenhof.circleimageview.CircleImageView

class UserListAdapter(val context: Context): PagingDataAdapter<Data, UserListAdapter.UserViewHolder>(DataDiff) {


    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {

        val user: Data? = getItem(position)

        user?.let {

            Glide.with(context)
                .load(it.avatar)
                .into(holder.circleImageView)

            holder.tvName.text = "${it.first_name} ${it.last_name}"
            holder.tvEmail.text = it.email
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user_list,parent,false)
        return UserViewHolder(view)
    }




    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val circleImageView: CircleImageView = itemView.findViewById(R.id.imgUser)
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvEmail: TextView = itemView.findViewById(R.id.tvemail)
    }


    object DataDiff : DiffUtil.ItemCallback<Data>() {

        // Called to check whether two items represent the same object.
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.id == newItem.id
        }

        // Called to check whether two items have the same data.
        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }
    }
}