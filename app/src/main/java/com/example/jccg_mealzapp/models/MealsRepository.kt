package com.example.jccg_mealzapp.models

import com.example.jccg_mealzapp.models.api.MealsWebService
import com.example.jccg_mealzapp.models.response.MealsCategoriesResponses
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MealsRepository(private val webservice: MealsWebService = MealsWebService()) {
    suspend fun getMeals(): MealsCategoriesResponses{
        return webservice.getMeals()

    }


}


