package com.generic.cook.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.generic.cook.R
import com.generic.cook.model.Recipes
import com.generic.cook.presenter.RecipesPresenter
import com.generic.cook.view.listener.RecipeListener

class RecipesActivity : AppCompatActivity(), RecipeListener {


  private val presenter: RecipesPresenter = RecipesPresenter(this)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_recipe)

    presenter.getRecipes()
  }

  override fun showRecipes(recipes: List<Recipes>) {

  }

  override fun showError() {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }
}
