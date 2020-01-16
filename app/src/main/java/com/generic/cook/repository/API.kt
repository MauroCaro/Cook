package com.generic.cook.repository

import com.generic.cook.model.Recipes
import retrofit2.Call
import retrofit2.http.GET

interface API {

  @GET("recipes")
  fun getRecipes(): Call<List<Recipes>>

}