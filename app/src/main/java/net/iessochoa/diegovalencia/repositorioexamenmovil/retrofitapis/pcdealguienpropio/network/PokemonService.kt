package net.iessochoa.diegovalencia.repositorioexamenmovil.retrofitapis.pcdealguienpropio.network

import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {

    // Aquí cogemos el listado de generaciones disponibles
    @GET("generation")
    suspend fun getGenerations(): GenerationsResponse

    // Aquí cogemos el listado de pokemons de una generación concreta
    @GET("generation/{id}")
    suspend fun getGenerationPokemons(@Path("id") id: Int): PokemonsByGenerationResponse

}