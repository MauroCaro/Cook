package com.generic.cook.view.listener

import com.generic.cook.model.Recipes

interface RecipeListener {

  fun showRecipes(recipes: List<Recipes>)

  fun showError()
}