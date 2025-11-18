package net.iessochoa.diegovalencia.repositorioexamenmovil.tarjetaspokemonpropio.composables


import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import net.iessochoa.diegovalencia.repositorioexamenmovil.tarjetaspokemonpropio.datasource.getPokemonddData

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DisplayCards(modifier: Modifier = Modifier) {

    var pokemons = remember { mutableStateListOf(*getPokemonddData().toTypedArray()) }

    var currentPokemon by remember { mutableStateOf(pokemons[0].nombre) }
    val onCurrentPokemonChange: (String) -> Unit = {currentPokemon = it}
    val onPokemonRatingChange: (Int) -> Unit = { newRating ->
        val index = pokemons.indexOfFirst { it.nombre == currentPokemon }
        if (index != -1) {
            pokemons[index] = pokemons[index].copy(rating = newRating)
        }
    }

    // Hace falta para enseñar el Snackbar
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar( title = {
                Text(
                    text = currentPokemon,
                    modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.headlineMedium
                )
            }, )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar(
                            message = "Pokemon ${currentPokemon} añadido a favoritos",
                            duration = SnackbarDuration.Short
                        )
                    }
                }
            ) {
                Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = null)
            }
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(8.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            DynamicSelectTextField(
                selectedValue = currentPokemon,
                options = pokemons.map { it.nombre },
                label = "Pokemons disponibles",
                onValueChangedEvent = onCurrentPokemonChange
            )

            ShowCard(
                image = pokemons.first{it.nombre == currentPokemon}.image,
                modifier = Modifier.fillMaxWidth()
            )

            RatingBar(
                maxRating = 5,
                currentRating = pokemons.first{it.nombre == currentPokemon}.rating,
                onRatingChanged = onPokemonRatingChange,
            )

            Text(
                text = "${pokemons.first{it.nombre == currentPokemon}.rating}"
            )

            Toast.makeText(LocalContext.current, "Has elegido a ${currentPokemon}", Toast.LENGTH_SHORT).show()
        }

    }

}

@Composable
fun ShowCard(
    @DrawableRes image: Int,
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier
    ){
        Image(
            painter = painterResource(image),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth().height(400.dp)
        )
    }
}