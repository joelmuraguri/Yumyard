package com.joel.domain.usecase.recipe

import com.joel.data.repos.RecipeRepository
import com.joel.domain.model.Recipe
import com.joel.domain.model.toRecipeDomainModel
import com.joel.domain.utils.Resource
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.utils.io.errors.IOException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetRandomRecipesUseCase @Inject constructor(
    private val repository: RecipeRepository
) {

    operator fun invoke() : Flow<Resource<List<Recipe>>> = flow {
        try {
            emit(Resource.Loading())
            val randomRecipes = repository.getRandomByCusinesRecipes()
            val recipes = randomRecipes.recipes.map { it.toRecipeDomainModel() }
            emit(Resource.Success(recipes))
        }
        catch(e : IOException){
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
        catch (e : ServerResponseException){
            emit(Resource.Error(e.localizedMessage ?: "5xx ERROR RESPONSE"))
        }
        catch (e : RedirectResponseException){
            emit(Resource.Error(e.localizedMessage ?: "3xx ERROR RESPONSE"))
        }
        catch (e : ClientRequestException){
            emit(Resource.Error(e.localizedMessage ?: "4xx ERROR RESPONSE"))
        }
    }

}