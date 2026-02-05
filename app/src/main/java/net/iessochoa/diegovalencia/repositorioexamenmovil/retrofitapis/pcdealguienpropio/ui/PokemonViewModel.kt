package net.iessochoa.diegovalencia.repositorioexamenmovil.retrofitapis.pcdealguienpropio.ui


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import net.iessochoa.diegovalencia.repositorioexamenmovil.retrofitapis.pcdealguienpropio.data.PokemonApi

class PokemonViewModel: ViewModel() {
    // Estado para la lista de pokemons
    val _uiState = MutableStateFlow(PokemonScreenUiState(
        currentState = PokemonUiState.Idle
    ))
    val uiState: StateFlow<PokemonScreenUiState> = _uiState.asStateFlow()

    // Función para llamar a la API
    fun fetchPokemonByGeneration(generationId: Int) {
        viewModelScope.launch {
            try {
                _uiState.update { currentState ->
                    currentState.copy(
                        currentState = PokemonUiState.Loading
                    )
                }

                val response = PokemonApi.retrofitService.getGenerationPokemons(generationId);
                _uiState.update { currentState ->
                    currentState.copy(
                        selectedGeneration = generationId,
                        pokemonList = response.pokemons,
                        currentState = PokemonUiState.Success(response.pokemons)
                    )
                }
            } catch (e: Exception) {
                e.printStackTrace()
                _uiState.update { currentState ->
                    currentState.copy(
                        currentState = PokemonUiState.Error
                    )
                }
            }
        }
    }
}