package com.example.jccg_mealzapp.details

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.jccg_mealzapp.models.MealsRepository
import com.example.jccg_mealzapp.models.response.MealResponse
import kotlinx.coroutines.internal.synchronized

class MealDetailViewModel(private val savedStateHandle: SavedStateHandle,

) : ViewModel() {

    private val repository: MealsRepository = MealsRepository.getInstance()
    val mealState = mutableStateOf<MealResponse?>(null) // to remember the state

    init {
        val mealId = savedStateHandle.get<String>("meal_categoryId")?:""
        mealState.value = repository.getMeal(mealId)//todo
    }




}