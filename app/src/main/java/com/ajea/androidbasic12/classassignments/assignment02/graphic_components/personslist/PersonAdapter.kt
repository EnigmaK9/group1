package com.ajea.androidbasic12.classassignments.assignment02.graphic_components.personslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ajea.androidbasic12.R

class PersonAdapter(val list: List<PersonEntity>): RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {
    class PersonViewHolder(view: View): RecyclerView.ViewHolder(view){
        val ivPerson = view.findViewById<ImageView>(R.id.ivPerson)
        val tvPersonName =  view.findViewById<TextView>(R.id.tvPersonName)
        val tvSurnames = view.findViewById<TextView>(R.id.tvSurname)
        fun render(personEntity: PersonEntity){
            tvPersonName.text = personEntity.name
            tvSurnames.text = personEntity.lastName
            ivPerson.setImageResource(
                when(personEntity.photo){
                    "w1" -> R.drawable.w1
                    "w2" -> R.drawable.w2
                    "w3" -> R.drawable.w3
                    "w4" -> R.drawable.w4
                    "w5" -> R.drawable.w5
                    "w6" -> R.drawable.w6
                    "w7" -> R.drawable.male05
                    else -> R.mipmap.ic_launcher
                }
            )
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        // view is the layout item for the list
        // parent is the parent view group
        // context is the context of the parent view group
        // inflater is used to inflate the layout item for the list into the parent view group
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent, false )
        return PersonViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.render(list[position])
    }
}
