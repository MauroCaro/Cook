package com.generic.cook.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.generic.cook.R
import com.generic.cook.model.Recipes
import com.generic.cook.view.RecipesDetailactivity

class RecipeAdapter(
    val context: Context,
    var list: MutableList<Recipes>
) : androidx.recyclerview.widget.RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.recipe_adapter, parent, false)
    return RecipeViewHolder(view)
  }

  override fun getItemCount(): Int {
    return list.size
  }

  override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
    var item = list[position]
    holder.titleRecipe.text = item.title

    holder.itemView.setOnClickListener {
      RecipesDetailactivity.start(context, item.id)
    }
  }

  class RecipeViewHolder internal constructor(itemView: View) :
      androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {

    internal var titleRecipe: TextView = itemView.findViewById<View>(R.id.recipe_name) as TextView
  }
}