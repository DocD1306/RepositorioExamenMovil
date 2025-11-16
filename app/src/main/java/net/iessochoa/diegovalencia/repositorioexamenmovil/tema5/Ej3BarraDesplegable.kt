package net.iessochoa.diegovalencia.repositorioexamenmovil.tema5


import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import net.iessochoa.diegovalencia.repositorioexamenmovil.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Ejercicio3(
    modifier: Modifier = Modifier
){

    val ejercicios: List<String> = stringArrayResource(R.array.opciones).toList()

    var ejercicioActual: String by remember { mutableStateOf(ejercicios[0]) }
    var onEjercicioActualChange: (String) -> Unit = { ejercicioActual = it }

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar( title = { Text(text = "T05OtrosComponentes: ${ejercicioActual}") })
        },
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    //muestra el SnackBar desde un hilo
                    scope.launch {
                        snackbarHostState.showSnackbar(
                            message = "Diego Fernando Valencia Correa: $ejercicioActual",
                            duration = SnackbarDuration.Short
                        )
                    }}
            ) {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = null
                )
            }
        }
    ) { innerPadding ->
        CambiarConDesplegable(
            ejercicios = ejercicios,
            ejercicioActual = ejercicioActual,
            onEjercicioActualChange = onEjercicioActualChange,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun CambiarConDesplegable(
    ejercicios: List<String>,
    ejercicioActual: String,
    onEjercicioActualChange: (String) -> Unit,
    modifier: Modifier = Modifier
){

    Column(
        modifier = modifier.padding(4.dp)
    ) {
        DynamicSelectTextField(
            selectedValue = ejercicioActual,
            options = ejercicios,
            label = stringResource(R.string.label_desplegable),
            onValueChangedEvent = onEjercicioActualChange,
        )
        when(ejercicioActual){
            stringArrayResource(R.array.opciones)[0] -> PizzaDisplay()
            stringArrayResource(R.array.opciones)[1] -> SliderColores()
        }
        Toast.makeText(LocalContext.current, "Has elegido $ejercicioActual", Toast.LENGTH_SHORT).show()

    }

}
