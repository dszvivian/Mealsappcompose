package com.example.jccg_mealzapp.ui.mealz

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.jccg_mealzapp.models.response.MealResponse
import com.example.jccg_mealzapp.ui.theme.JCCG_MealzAppTheme

@Composable
fun MealsCategoriesScreen(name: String) {
    val viewModel: MealsCategoriesViewModel = viewModel()

    val meals = viewModel.rememberList.value

    LazyColumn{
        items(meals){meal->
            MealCard(Meal = meal)
        }
    }

}

@Composable
fun MealCard(Meal: MealResponse){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(20.dp)
        ,
        shape = RoundedCornerShape(20.dp),
        elevation = 10.dp
    ) {
        Row{
            Card(shape = CircleShape) {
                AsyncImage(model = Meal.imageUrl,
                    contentDescription = "meals_image",
                    modifier = Modifier
                        .size(120.dp, 120.dp)
                        .padding(12.dp),
                    contentScale = ContentScale.Crop
                )
            }

            Column {
                Text(text = Meal.name , fontSize = 23.sp)
                Text(text = Meal.description,
                    fontSize = 13.sp,
                    maxLines = 5
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JCCG_MealzAppTheme {
        MealsCategoriesScreen("Android")
    }
}