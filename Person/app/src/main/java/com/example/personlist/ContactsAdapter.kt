package com.example.personlist

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.contracts.contract

class ContactsAdapter(var contacts: MutableList<Person>,var context: Context) : RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
var view =LayoutInflater.from(context).inflate(R.layout.item_person,parent,false)
        return ContactsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
var contact = contacts[position]
        holder.binddata(contact)
    }

    override fun getItemCount(): Int {
        Log.i(TAG, "getItemCount: ${contacts.size}")
return   contacts.size   }

    inner class ContactsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var personName= itemView.findViewById<TextView>(R.id.tvName)
        var personAge= itemView.findViewById<TextView>(R.id.tvAge)
        fun binddata(contact: Person) {
            var agge= contact.age.toString().toInt()
          personName.text=contact.name.toString()
            personAge.text= "Age: $agge"
            Log.i(TAG, "binddata: ${personName.text} ${personAge.text}")
        }
    }
}
