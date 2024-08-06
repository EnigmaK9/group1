package com.ajea.androidbasic12.classassignments.assignment02.graphic_components.listpeople

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ajea.androidbasic12.R

class PeopleAdapter(private val list: List<PeopleEntity>) : RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder>() {

    class PeopleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val ivPerson: ImageView = view.findViewById(R.id.personImage)
        private val tvName: TextView = view.findViewById(R.id.personName)
        private val tvRole: TextView = view.findViewById(R.id.personRole)

        fun render(person: PeopleEntity) {
            tvName.text = person.name
            tvRole.text = person.role
            val resourceId = itemView.context.resources.getIdentifier(person.image, "drawable", itemView.context.packageName)
            ivPerson.setImageResource(resourceId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_people, parent, false)
        return PeopleViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        holder.render(list[position])
    }
}

