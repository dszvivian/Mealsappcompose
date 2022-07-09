package com.example.jccg_mealzapp.models

import com.example.jccg_mealzapp.models.api.MealsWebService
import com.example.jccg_mealzapp.models.response.MealResponse
import com.example.jccg_mealzapp.models.response.MealsCategoriesResponses


class MealsRepository(private val webservice: MealsWebService = MealsWebService()) {

    var cachedMeals = listOf<MealResponse>()

    suspend fun getMeals(): MealsCategoriesResponses{
        val response = webservice.getMeals()
        cachedMeals  = response.categories
        return response

    }

    fun getMeal(id : String) : MealResponse? {
        return cachedMeals.firstOrNull{
            it.id == id
        }
    }

    companion object{
        @Volatile
        private var instance: MealsRepository? = null

        fun getInstance() = instance?: kotlin.synchronized(this){
            instance ?: MealsRepository().also { instance = it  }
        }

    }



}


