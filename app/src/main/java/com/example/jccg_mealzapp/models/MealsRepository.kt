package com.example.jccg_mealzapp.models

import com.example.jccg_mealzapp.models.api.MealsWebService
import com.example.jccg_mealzapp.models.response.MealsCategoriesResponses
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MealsRepository(private val webservice: MealsWebService = MealsWebService()) {
    fun getMeals(successCallback: (response : MealsCategoriesResponses?) -> Unit){
        return webservice.getMeals().enqueue(object : retrofit2.Callback<MealsCategoriesResponses> {
            override fun onResponse(
                call: Call<MealsCategoriesResponses>,
                response: Response<MealsCategoriesResponses>,
            ) {
                if(response.isSuccessful)
                    successCallback(response.body())
            }

            override fun onFailure(call: Call<MealsCategoriesResponses>, t: Throwable) {
                //TODO treat failure
            }


        })
    }

    //todo : retrofit
}


