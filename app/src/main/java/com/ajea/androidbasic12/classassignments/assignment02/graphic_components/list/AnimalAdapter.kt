package com.ajea.androidbasic12.classassignments.assignment02.graphic_components.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ajea.androidbasic12.R

class AnimalAdapter(val list: List<animalEntity>) : RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    class AnimalViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivAnimal: ImageView = view.findViewById(R.id.ivAnimal)
        val tvAnimal: TextView = view.findViewById(R.id.tvAnimal)
        val tvColor: TextView = view.findViewById(R.id.tvColor)

        fun render(animal: animalEntity) {
            tvAnimal.text = animal.name
            tvColor.text = animal.color
            // Aquí puedes cargar la imagen usando una biblioteca como Glide o Picasso
            // Por ejemplo, usando Glide:
            // Glide.with(itemView.context).load(animal.image).into(ivAnimal)
            // Si los recursos son imágenes locales, usa setImageResource:
            val resourceId = itemView.context.resources.getIdentifier(animal.image, "drawable", itemView.context.packageName)
            ivAnimal.setImageResource(resourceId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_animal, parent, false)
        return AnimalViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.render(list[position])
    }
}
