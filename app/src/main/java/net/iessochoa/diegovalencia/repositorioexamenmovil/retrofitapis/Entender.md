### Carpeta Network

Aquí van los datos que vienen de la red.

Creamos una clase llamada ...Dtos.kt y metemos data clases con los datos
que nos llegan en el JSON desde internet. Si los nombres de los campos son distintos 
utilizamos la etiqueta 

    @SerialName(value="nombre_en_el_json") val nombreEnTuDto: TipoDeDato

Ejemplo con pokemons:

    // Esto es para coger las generaciones disponibles de pokemons
    @Serializable
    data class GenerationsResponse(
        val results: List<GenerationDto>
    )
    
    // Nombre de la generación y su url
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
    
    // Nombre del pokemon y la url de su foto (luego se usará con coil)
    @Serializable
    data class PokemonDto(
        val name: String,
        val url: String
    )

Ahora, de nuevo dentro de la carpeta network creamos una clase llamada ...ApiService.kt
que será una interface.

Ejemplo con pokemon:

    interface PokemonService {

    // Aquí cogemos el listado de generaciones disponibles
    @GET("generation")
    suspend fun getGenerations(): GenerationsResponse

    // Aquí cogemos el listado de pokemons de una generación concreta
    @GET("generation/{id}")
    suspend fun getGenerationPokemons(@Path("id") id: Int): PokemonsByGenerationResponse

}

Después, creamos una carpeta llamada data, aquí hemos de crear un objeto singleton 
de Retrofit:

    // Cambias la URL por la que toque
    private const val BASE_URL = "https://pokeapi.co/api/v2/";

    // El Builder
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json {
            ignoreUnknownKeys = true // Esto es importante para que solo pille los campos de tu dto
        }.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()
    
    // Objeto singleton
    // Le cambias el nombre por el que tenga que ser
    object PokemonApi {
        // Inicializamos el service de manera perezosa
        val retrofitService: PokemonService by lazy { // Pones el nombre de tu service
            retrofit.create(PokemonService::class.java) // Pones tu service
        }
    }

En el ViewModel inicializamos el UiState:

    class PokemonViewModel: ViewModel() {

        // Estado para la lista de pokemons
        val _uiState = MutableStateFlow(PokemonScreenUiState(
            currentState = PokemonUiState.Loading // Ponemos por defecto cargano o el que toque
        ))
        val uiState: StateFlow<PokemonScreenUiState> = _uiState.asStateFlow()


Después creamos las funciones que nos pidan en el examen, en este ejemplo cogemos
una lista de pokemon dada una generación:

    fun fetchPokemonByGeneration(generationId: Int) {
        viewModelScope.launch {
            try {

                // Utilizamos el objeto del archivo ...Repository.kt
                // Nos metemos en el service que hay dentro del objeto
                // Por último llamamos al método que necesitemos 
                val response = PokemonApi.retrofitService.getGenerationPokemons(generationId);
                
                // Actualizamos el uiState con la generación actual y la lista de pokemons
                // que hemos recuperado en la línea anterior
                // También cambiamos la implementación de la interfaz en el UiState
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

Esta sería una demostración de un UiState:
    
    data class PokemonScreenUiState (
        val pokemonList: List<PokemonDto> = emptyList(),
        val selectedGeneration: Int = 1,
        val totalGenerations: Int = 1,
        val currentState: PokemonUiState = PokemonUiState.Idle
    )
    
    // Una interfaz para marcar el estado de la pantalla actual
    sealed interface PokemonUiState {
        object Loading: PokemonUiState
        data class Success(val pokemonList: List<PokemonDto>): PokemonUiState
        object Error: PokemonUiState
        object Idle: PokemonUiState
    }

Ya luego lo último sería cambiar los composables que te de Sergio y enchufarles
los métodos del viewModel y el uiState