package com.generic.cook.presenter

import android.util.Log
import com.generic.cook.model.Recipes
import com.generic.cook.repository.API
import com.generic.cook.repository.Repository
import com.generic.cook.view.listener.RecipeListener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecipesPresenter(val lister: RecipeListener) {

  val api = Repository.provideClient().create(API::class.java)

  fun getRecipes(){
    val call = api.getRecipes()

    call.enqueue(object : Callback<List<Recipes>> {
      override fun onResponse(call: Call<List<Recipes>>, response: Response<List<Recipes>>) {
        var listRecipes = response.body() as List<Recipes>
        lister.showRecipes(listRecipes)
      }
      override fun onFailure(call: Call<List<Recipes>>, t: Throwable) {
        lister.showError()
      }
    })
  }

  fun getRecipeDetail(idRecipe : Int){
 
  }
}