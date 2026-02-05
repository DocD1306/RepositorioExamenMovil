package net.iessochoa.diegovalencia.repositorioexamenmovil.retrofitapis.rickymorty.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import net.iessochoa.diegovalencia.repositorioexamenmovil.retrofitapis.pcdealguienpropio.data.PokemonApi
import net.iessochoa.diegovalencia.repositorioexamenmovil.retrofitapis.pcdealguienpropio.ui.PokemonScreenUiState
import net.iessochoa.diegovalencia.repositorioexamenmovil.retrofitapis.pcdealguienpropio.ui.PokemonUiState
import net.iessochoa.diegovalencia.repositorioexamenmovil.retrofitapis.rickymorty.data.RickApi


class RickViewModel: ViewModel() {
    // Estado para la lista de pokemons
    val _uiState = MutableStateFlow(RickScreenUiState(
        currentState = RickUiState.Idle
    ))
    val uiState: StateFlow<RickScreenUiState> = _uiState.asStateFlow()

    fun getSingleChacter(id: Int){
        viewModelScope.launch {
            try {
                val character = RickApi.retrofitService.getSingularCharacter(id)
                _uiState.update { currentState ->
                    currentState.copy(
                        currentCharacter = character
                    )
                }
            } catch (e: Exception){
                e.printStackTrace()
                _uiState.update { currentState ->
                    currentState.copy(
                        currentState = RickUiState.Error
                    )
                }
            }
        }
    }

    fun getCharactersByPage(page: Int) {
        viewModelScope.launch {
            try {
                val response = RickApi.retrofitService.getCharactersByPage(page);
                _uiState.update { currentState ->
                    currentState.copy(
                        characterList = response.results,
                        currentState = RickUiState.Success(response.results)
                    )
                }
            } catch (e: Exception) {
                e.printStackTrace()
                _uiState.update { currentState ->
                    currentState.copy(
                        currentState = RickUiState.Error
                    )
                }
            }
        }
    }

    // Función para llamar a la API
    fun getCharacters() {
        viewModelScope.launch {
            try {
                // TODO 4: Llamar a RetrofitClient y actualizar _pokemonList
                // val response = RetrofitClient.service.getGeneration(generationId)
                // _pokemonList.value = ...
                val response = RickApi.retrofitService.getCharacters();
                _uiState.update { currentState ->
                    currentState.copy(
                        characterList = response.results,
                        currentState = RickUiState.Success(response.results)
                    )
                }
            } catch (e: Exception) {
                e.printStackTrace()
                _uiState.update { currentState ->
                    currentState.copy(
                        currentState = RickUiState.Error
                    )
                }
            }
        }
    }
}