package net.iessochoa.diegovalencia.repositorioexamenmovil.retrofitapis.pcdealguienpropio.data

import kotlinx.serialization.json.Json
import net.iessochoa.diegovalencia.repositorioexamenmovil.retrofitapis.pcdealguienpropio.network.PokemonService
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

private const val BASE_URL = "https://pokeapi.co/api/v2/";

//private val retrofit = Retrofit.Builder()
//    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
//    .baseUrl(BASE_URL)
//    .build()

//private val retrofit: Retrofit by lazy {
//    Retrofit.Builder()
//        .addConverterFactory(Json {
//            ignoreUnknownKeys = true
//        }.asConverterFactory("application/json".toMediaType()))
//        .baseUrl(BASE_URL)
//        .build()
//}

// Este es el que hay que usar porque hay que poner el ignoreUnkownKeys
private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json {
            ignoreUnknownKeys = true
        }.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()


object PokemonApi {
    val retrofitService: PokemonService by lazy {
        retrofit.create(PokemonService::class.java)
    }
}

// Esta es la estructura básica de singleton para el repository
// Utilizamos el service que definimos antes junto con su url base

