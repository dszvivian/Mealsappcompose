package com.example.jccg_mealzapp.ui.mealz

import androidx.lifecycle.ViewModel
import com.example.jccg_mealzapp.models.MealsRepository
import com.example.jccg_mealzapp.models.response.MealResponse
import com.example.jccg_mealzapp.models.response.MealsCategoriesResponses

class MealsCategoriesViewModel(private val repository: MealsRepository = MealsRepository()) : ViewModel() {

    fun getMeals(successCallback: (response : MealsCategoriesResponses?)-> Unit){
        repository.getMeals{response ->
            successCallback(response)
        }
    }


}