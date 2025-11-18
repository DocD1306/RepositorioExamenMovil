package net.iessochoa.diegovalencia.repositorioexamenmovil.tema5


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.iessochoa.diegovalencia.repositorioexamenmovil.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PizzaDisplay(modifier: Modifier = Modifier){

    val ingredientes = stringArrayResource(R.array.ejercicio1_ingredientes).toList()
    var ingredientesR by remember { mutableStateOf(listOf<String>()) }

    val onIngredienteChange: (String, Boolean) -> Unit = { ingredientName, isChecked ->
        // Esto crea una nueva lista en ingredientesR con el contenido previo más o menos el ingrediente
        ingredientesR = if (isChecked) {
            ingredientesR + ingredientName
        } else {
            ingredientesR - ingredientName
        }
    }

    val precio: String = (10 + 2 * ingredientesR.size).toString()

    var indiceChecks: MutableList<Int> = mutableListOf()

    ingredientes.forEachIndexed { index, ingrediente ->
        if(ingredientesR.contains(ingrediente)){
            indiceChecks.add(index);
        }
    }

    Column (
        modifier = modifier
    ) {

        Text(
            text = stringResource(R.string.ejercicio1_titulo),
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            textAlign = TextAlign.Center
        )

        IngredientesChecks(
            ingredientes = ingredientes,
            ingredientesSeleccionados = ingredientesR,
            onIngredienteChange = onIngredienteChange,
            modifier = Modifier.fillMaxWidth()
        )

        Row (
            modifier = Modifier.padding(top = 32.dp)
        ) {
            Text(
                text = "Total: ${precio}€",
                style = MaterialTheme.typography.displayLarge
            )
        }

        ImagenesIngredientes(
            ingredientes = ingredientes,
            indiceChecks = indiceChecks
        )

    }
}

// Funcion para los botones
@Composable
fun IngredientesChecks(
    ingredientes: List<String>,
    ingredientesSeleccionados: List<String>,
    onIngredienteChange: (String, Boolean) -> Unit,
    modifier: Modifier = Modifier
){
    Column (
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        ingredientes.forEach {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = ingredientesSeleccionados.contains(it),
                    onCheckedChange = { isChecked -> onIngredienteChange(it, isChecked) }
                )
                Text(
                    text = it
                )
            }
        }

    }
}

// Crear cuadros, vacios o con imagen
@Composable
fun ImagenesIngredientes(
    ingredientes: List<String>,
    indiceChecks: List<Int>,
    modifier: Modifier = Modifier
){
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        ingredientes.forEachIndexed { index, ingrediente ->
            if(indiceChecks.contains(index)) {
                when(index) {
                    0 -> PintarIngrediente(painterResource(R.drawable.cheese), modifier.weight(1f))
                    1 -> PintarIngrediente(painterResource(R.drawable.pinya), modifier.weight(1f))
                    2 -> PintarIngrediente(painterResource(R.drawable.tomate), modifier.weight(1f))
                }
            } else {
                Row(modifier.weight(1f)){}
            }
        }
    }
}

// Pintar una imagen
@Composable
fun PintarIngrediente(
    imagen: Painter,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
    ){
        Image(
            painter = imagen,
            contentDescription = null
        )
    }
}