package com.joel.domain.usecase.recipe

import com.joel.data.repos.RecipeRepository
import com.joel.domain.model.Recipe
import com.joel.domain.model.toRecipeDomainModel
import com.joel.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetRandomMealTypesRecipesUseCase(
    private val repository: RecipeRepository
) {

    operator fun invoke(mealType : String) : Flow<Resource<List<Recipe>>> = flow {
        try {
            emit(Resource.Loading())
            val randomRecipes = repository.getRandomByMealTypesRecipes(mealType)
            val recipes = randomRecipes.recipes.map { it.toRecipeDomainModel() }
            emit(Resource.Success(recipes))
        }
        catch(e : IOException){
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
        catch (e : HttpException){
            emit(Resource.Error("Oops. Something went wrong."))
        }
    }
}