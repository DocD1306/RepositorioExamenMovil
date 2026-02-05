package net.iessochoa.diegovalencia.repositorioexamenmovil.retrofitapis.rickymorty.network

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickService {

    @GET("character")
    suspend fun getCharacters(): CharactersResultDto

    @GET("character/{id}")
    suspend fun getSingularCharacter(@Path("id") id: Int): CharacterDto

    @GET("character")
    suspend fun getCharactersByPage(@Query("page") page: Int): CharactersResultDto

}