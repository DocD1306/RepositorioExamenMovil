package net.iessochoa.diegovalencia.repositorioexamenmovil.retrofitapis.rickymorty.ui

import net.iessochoa.diegovalencia.repositorioexamenmovil.retrofitapis.pcdealguienpropio.network.PokemonDto
import net.iessochoa.diegovalencia.repositorioexamenmovil.retrofitapis.rickymorty.network.CharacterDto



data class RickScreenUiState (
    val characterList: List<CharacterDto> = emptyList(),
    val currentCharacter: CharacterDto = CharacterDto("", ""),
    val currentState: RickUiState = RickUiState.Idle
)

sealed interface RickUiState {
    object Loading: RickUiState
    data class Success(val characterList: List<CharacterDto>): RickUiState
    object Error: RickUiState
    object Idle: RickUiState
}