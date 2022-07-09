package com.example.jccg_mealzapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jccg_mealzapp.details.MealDetailViewModel
import com.example.jccg_mealzapp.details.MealDetailsScreen
import com.example.jccg_mealzapp.ui.mealz.MealsCategoriesScreen
import com.example.jccg_mealzapp.ui.theme.JCCG_MealzAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JCCG_MealzAppTheme {
                    MealzApp()
            }
        }
    }
}


@Composable
fun MealzApp(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "destination_mealsList"){
        composable("destination_mealsList"){
            MealsCategoriesScreen(){navigationMealId ->
                navController.navigate("destination_mealsDetail/$navigationMealId")
            }
        }
        composable(
            route = "destination_mealsDetail/{meal_categoryId}",
            arguments = listOf(navArgument("meal_categoryId"){
                type = NavType.StringType
            })
            ){
            val viewModel : MealDetailViewModel = viewModel()
            MealDetailsScreen(meal = viewModel.mealState.value)//Todo: extract meal response from ViewModel
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JCCG_MealzAppTheme {
        MealzApp()
    }
}





