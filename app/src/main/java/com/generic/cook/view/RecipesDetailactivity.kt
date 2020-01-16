package com.generic.cook.view

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.generic.cook.R

class RecipesDetailactivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_recipe_detail)
  }


  companion object {
    const val ID_SELECTED = "Id"
    fun start(context: Context, IdRecipe: Int? = null) {
      val intent = Intent(context, RecipesDetailactivity::class.java)
      IdRecipe.let {
        intent.putExtra(ID_SELECTED, IdRecipe)
        context.startActivity(intent)
        (context as? Activity)?.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
      } ?: kotlin.run {
        Toast.makeText((context as? Activity), "There was an error loading the information", Toast.LENGTH_LONG)
          .show()
      }
    }
  }
}
