package net.iessochoa.diegovalencia.repositorioexamenmovil.retrofitapis.rickymorty.data

import kotlinx.serialization.json.Json
import net.iessochoa.diegovalencia.repositorioexamenmovil.retrofitapis.rickymorty.network.RickService
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

private const val BASE_URL = "https://rickandmortyapi.com/api/";

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json {
        ignoreUnknownKeys = true
    }.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()


object RickApi {
    val retrofitService: RickService by lazy {
        retrofit.create(RickService::class.java)
    }
}


/*
object RickAndMortyRepository {

    private const val BASE_URL = "https://rickandmortyapi.com/api/"

    private val json = Json {
        ignoreUnknownKeys = true
    }

    //Empezamos a inicializar primero Retrofit, siempre lazy.
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .baseUrl(BASE_URL)
            .build()
    }

    private val retrofitService: RickAndMortyApiService by lazy {
        retrofit.create(RickAndMortyApiService::class.java)
    }

    suspend fun getCharacter(): RickAndMortyResponse {
        return retrofitService.getCharacter()
    }

    suspend fun getCharacterById(id: Int): CharacterResults {
        return retrofitService.getCharacterId(id)
    }

    suspend fun getCharacterByPage(page: Int) : RickAndMortyResponse {
        return retrofitService.getCharactersByPage(page)
    }

}
 */