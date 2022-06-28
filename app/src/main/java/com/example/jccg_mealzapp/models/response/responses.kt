package com.example.jccg_mealzapp.models.response

import com.google.gson.annotations.SerializedName

data class MealsCategoriesResponses(val categories: List<MealResponse>)

//Gson deserialization
//JSON -> data class


data class MealResponse(
    @SerializedName("idCategory") val id :String,
    @SerializedName("strCategory") val name :String,
    @SerializedName("strCategoryDescription") val description :String,
    @SerializedName("strCategoryThumb") val imageUrl :String
)
