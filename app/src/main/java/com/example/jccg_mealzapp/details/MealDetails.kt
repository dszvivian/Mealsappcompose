package com.example.jccg_mealzapp.details

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.jccg_mealzapp.models.response.MealResponse
import kotlin.math.max
import kotlin.math.min

@Composable
fun MealDetailsScreen(meal: MealResponse?){

    var scrollState = rememberScrollState()
    val offset = min(1f,1-(scrollState.value/600f))
    val size by animateDpAsState(targetValue =androidx.compose.ui.unit.max(100.dp, 200.dp * offset) )


    Surface(color = MaterialTheme.colors.background ) {
        Column {
            
            Surface(elevation = 8.dp) {
                Row( modifier = Modifier.fillMaxWidth()) {

                    Card(modifier = Modifier
                        .padding(16.dp),
                        shape = CircleShape,
                        border = BorderStroke(2.dp , Color.Magenta)

                    ){

                        Image(
                            painter =  rememberAsyncImagePainter(model = meal?.imageUrl),
                            contentDescription = "" ,
                            modifier = Modifier
                                .size(size)
                                .padding(8.dp)
                        )

                    }


                    Text(text = meal?.name?:"default name",
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.CenterVertically) ,
                        style = MaterialTheme.typography.h5

                    )
                }
            }

            //Just to test the collapsing toolBar
            Column(modifier = Modifier.verticalScroll(scrollState)) {
                Text(text = "Just to test the collapsing toolBar", modifier = Modifier.padding(40.dp))
                Text(text = "Just to test the collapsing toolBar", modifier = Modifier.padding(40.dp))
                Text(text = "Just to test the collapsing toolBar", modifier = Modifier.padding(40.dp))
                Text(text = "Just to test the collapsing toolBar", modifier = Modifier.padding(40.dp))
                Text(text = "Just to test the collapsing toolBar", modifier = Modifier.padding(40.dp))
                Text(text = "Just to test the collapsing toolBar", modifier = Modifier.padding(40.dp))
                Text(text = "Just to test the collapsing toolBar", modifier = Modifier.padding(40.dp))
                Text(text = "Just to test the collapsing toolBar", modifier = Modifier.padding(40.dp))
                Text(text = "Just to test the collapsing toolBar", modifier = Modifier.padding(40.dp))
                Text(text = "Just to test the collapsing toolBar", modifier = Modifier.padding(40.dp))
                Text(text = "Just to test the collapsing toolBar", modifier = Modifier.padding(40.dp))
                Text(text = "Just to test the collapsing toolBar", modifier = Modifier.padding(40.dp))
                Text(text = "Just to test the collapsing toolBar", modifier = Modifier.padding(40.dp))
                Text(text = "Just to test the collapsing toolBar", modifier = Modifier.padding(40.dp))
                Text(text = "Just to test the collapsing toolBar", modifier = Modifier.padding(40.dp))
                Text(text = "Just to test the collapsing toolBar", modifier = Modifier.padding(40.dp))
                Text(text = "Just to test the collapsing toolBar", modifier = Modifier.padding(40.dp))
                Text(text = "Just to test the collapsing toolBar", modifier = Modifier.padding(40.dp))
                Text(text = "Just to test the collapsing toolBar", modifier = Modifier.padding(40.dp))
                Text(text = "Just to test the collapsing toolBar", modifier = Modifier.padding(40.dp))
                Text(text = "Just to test the collapsing toolBar", modifier = Modifier.padding(40.dp))
                Text(text = "Just to test the collapsing toolBar", modifier = Modifier.padding(40.dp))
            }



        }
    }




    
}

enum class MealPictureAnimationState(val size :Dp ,val width:Dp , val color: Color){
    Normal(200.dp ,5.dp, Color.Magenta),
    Expanded(600.dp,10.dp,Color.Red)
}