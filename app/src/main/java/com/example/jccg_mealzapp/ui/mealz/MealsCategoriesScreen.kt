package com.example.jccg_mealzapp.ui.mealz

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.jccg_mealzapp.models.response.MealResponse
import com.example.jccg_mealzapp.ui.theme.JCCG_MealzAppTheme

@Composable
fun MealsCategoriesScreen(navigationCallback: (String) -> Unit) {
    val viewModel: MealsCategoriesViewModel = viewModel()

    val meals = viewModel.rememberList.value

    LazyColumn(){
        items(meals){meal->
            MealCard(meal = meal , navigationCallback = navigationCallback )
        }
    }

}

@Composable
fun MealCard(meal: MealResponse , navigationCallback: (String) -> Unit ){

    var isExpanded by remember { mutableStateOf(false)}

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(20.dp)
            .clickable {
                       navigationCallback(meal.id)
            }
        ,
        elevation = 10.dp
    ) {
        Row(modifier = Modifier.animateContentSize()){
            Card( modifier = Modifier.padding(20.dp) ) {
                AsyncImage(model = meal.imageUrl,
                    contentDescription = "meals_image",
                    modifier = Modifier
                        .size(120.dp, 120.dp)
                        .padding(12.dp),
                    contentScale = ContentScale.Fit
                )
            }

            Column(modifier = Modifier
                .fillMaxWidth(0.8f)
                .align(Alignment.CenterVertically)
            )
            {
                Text(text = meal.name ,
                    modifier = Modifier
                        .padding(0.dp,5.dp,0.dp,0.dp)
                    ,
                    style = MaterialTheme.typography.h5)

                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium){
                    Text(text =
                        if(!isExpanded)
                            "more info..."
                        else
                            meal.description,
                        textAlign = TextAlign.Start ,
                        style = MaterialTheme.typography.subtitle2,
                        overflow = TextOverflow.Ellipsis,
                        //maxLines = if(isExpanded) 10 else 4
                    )
                }



            }

            Icon(
                imageVector =
                if(isExpanded)
                    Icons.Filled.KeyboardArrowUp
                else
                    Icons.Filled.KeyboardArrowDown
                ,
                contentDescription = "",
                modifier = Modifier
                    .padding(6.dp)
                    .align(

                        if(!isExpanded)
                            Alignment.CenterVertically
                        else
                            Alignment.Bottom
                    )
                    .clickable { isExpanded = !isExpanded }
            )

        }

    }
}

