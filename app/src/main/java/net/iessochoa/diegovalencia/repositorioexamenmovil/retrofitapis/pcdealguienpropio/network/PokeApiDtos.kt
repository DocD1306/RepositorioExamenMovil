package net.iessochoa.diegovalencia.repositorioexamenmovil.retrofitapis.pcdealguienpropio.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// Esto es para coger las generaciones disponibles de pokemons
@Serializable
data class GenerationsResponse(
    val results: List<GenerationDto>
)

@Serializable
data class GenerationDto(
    val name: String,
    val url: String
)


// Esto es para coger los pokemons dentro de una generación específica
@Serializable
data class PokemonsByGenerationResponse(
    @SerialName(value = "pokemon_species") val pokemons: List<PokemonDto>
)

@Serializable
data class PokemonDto(
    val name: String,
    val url: String
)