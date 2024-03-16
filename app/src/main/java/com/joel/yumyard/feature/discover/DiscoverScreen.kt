package com.joel.yumyard.feature.discover

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.joel.domain.model.Recipe
import com.joel.yumyard.di.ViewModelFactory
import timber.log.Timber

@Composable
fun DiscoverScreen(){
    val viewModel: DiscoverViewModel = viewModel(factory = ViewModelFactory.Factory)
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            LazyRow(modifier = Modifier.fillMaxWidth()) {
                item {
                    Text(
                        text = "MEAL TYPE",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
                items(state.recipesMealTypes) { recipe ->
                    RecipeItem(recipe = recipe)
                }
            }
            LazyRow(modifier = Modifier.fillMaxWidth()) {
                item {
                    Text(
                        text = "DIETS",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
                items(state.recipesDiets) { recipe ->
                    RecipeItem(recipe = recipe)
                }
            }
            LazyRow(modifier = Modifier.fillMaxWidth()) {
                item {
                    Text(
                        text = "CUISINES",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
                items(state.recipesCuisines) { recipe ->
                    RecipeItem(recipe = recipe)
                }
            }
            if(state.error.isNotBlank()) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = state.error,
                        color = Color.Red,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)

                    )
                }
            }
            if(state.loading) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    CircularProgressIndicator()
                }
            }
        }
    }
}

@Composable
fun DiscoverByFiltering(){

    Box {
        Text(
            text = "Discover",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun RecipeItem(
    recipe: Recipe,
) {

    Card(

    ) {

        Column {
            Text(text = recipe.title)
            Text(text =  " READY IN: ${recipe.readyInMinutes} minutes")
        }

    }

}