package com.generic.cook.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.generic.cook.R
import com.generic.cook.model.Recipes
import com.generic.cook.presenter.RecipesPresenter
import com.generic.cook.view.adapter.RecipeAdapter
import com.generic.cook.view.listener.RecipeListener
import kotlinx.android.synthetic.main.activity_recipe.*

class RecipesActivity : AppCompatActivity(), RecipeListener {

  private val presenter: RecipesPresenter = RecipesPresenter(this)
  lateinit var adapter: RecipeAdapter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_recipe)

    presenter.getRecipes()
  }

  override fun showRecipes(recipes: List<Recipes>) {
    adapter = RecipeAdapter(this, recipes)
    rv_default_post?.adapter = adapter
    rv_default_post?.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
    rv_default_post?.isNestedScrollingEnabled = false
  }

  override fun showError() {
    Toast.makeText(this, "There was a error loading the recipes", Toast.LENGTH_SHORT).show()
  }
}
