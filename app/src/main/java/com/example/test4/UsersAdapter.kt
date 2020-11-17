package com.example.test4


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import posts_data


//адаптер для отображения данных в recyclerview
class UsersAdapter (private val users: List<User>) : RecyclerView.Adapter<UsersAdapter.ViewHolder>(){

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var name: TextView? = null
        init{
            name = itemView?.findViewById((R.id.name))
        }
        var email: TextView? = null
        init{
            email = itemView?.findViewById((R.id.email))
        }
        var phone: TextView? = null
        init{
            phone = itemView?.findViewById((R.id.phone))
        }
        var website: TextView? = null
        init{
            website = itemView?.findViewById((R.id.website))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_row2, parent, false) //user_row
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name?.text = users[position].name
        holder.email?.text = users[position].email
        holder.phone?.text = users[position].phone
        holder.website?.text = users[position].website
    }

    override fun getItemCount() = users.size

}