package com.example.jccg_mealzapp.ui.mealz

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import com.example.jccg_mealzapp.models.MealsRepository
import com.example.jccg_mealzapp.models.response.MealResponse
import com.example.jccg_mealzapp.models.response.MealsCategoriesResponses
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MealsCategoriesViewModel(private val repository: MealsRepository = MealsRepository()) : ViewModel() {

    private val mealsJob = Job()
    init{
        val scope = CoroutineScope(mealsJob+Dispatchers.IO)
            scope.launch {
            val meals = getMeals()
            rememberList.value = meals
        }

    }


    private suspend fun getMeals():List<MealResponse>{
        return repository.getMeals().categories
    }


    val rememberList: MutableState<List<MealResponse>> = mutableStateOf(emptyList<MealResponse>())


    override fun onCleared() {
        super.onCleared()
        mealsJob.cancel()
    }

}