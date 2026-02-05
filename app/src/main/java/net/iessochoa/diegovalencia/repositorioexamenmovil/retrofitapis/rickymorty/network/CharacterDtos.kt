package net.iessochoa.diegovalencia.repositorioexamenmovil.retrofitapis.rickymorty.network

import kotlinx.serialization.Serializable

@Serializable
data class CharactersResultDto(
    val results: List<CharacterDto>
)

@Serializable
data class CharacterDto(
    val name: String,
    val image: String
)