package net.iessochoa.diegovalencia.repositorioexamenmovil.retrofitapis.pcdealguienpropio.ui

import net.iessochoa.diegovalencia.repositorioexamenmovil.retrofitapis.pcdealguienpropio.network.PokemonDto

data class PokemonScreenUiState (
    val pokemonList: List<PokemonDto> = emptyList(),
    val selectedGeneration: Int = 1,
    val totalGenerations: Int = 1,
    val currentState: PokemonUiState = PokemonUiState.Idle
)

sealed interface PokemonUiState {
    object Loading: PokemonUiState
    data class Success(val pokemonList: List<PokemonDto>): PokemonUiState
    object Error: PokemonUiState
    object Idle: PokemonUiState
}