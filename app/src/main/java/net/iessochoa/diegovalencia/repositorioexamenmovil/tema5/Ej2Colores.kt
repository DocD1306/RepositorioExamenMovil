package net.iessochoa.diegovalencia.repositorioexamenmovil.tema5


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SliderColores(modifier: Modifier = Modifier) {

    var red by remember { mutableFloatStateOf(0f) }
    val onRedChange: (Float) -> Unit = { red = it }

    var green by remember { mutableFloatStateOf(0f) }
    val onGreenChange: (Float) -> Unit = { green = it }

    var blue by remember { mutableFloatStateOf(0f) }
    val onBlueChange: (Float) -> Unit = { blue = it }


    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Ejercicio 2",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(vertical = 32.dp)
        )
        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "R",
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.width(12.dp))
            Slider(
                value = red,
                onValueChange = onRedChange,
                valueRange = 0f..255f,
            )

        }

        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "G",
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.width(12.dp))
            Slider(
                value = green,
                onValueChange = onGreenChange,
                valueRange = 0f..255f,
            )
        }
        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "B",
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.width(12.dp))
            Slider(
                value = blue,
                onValueChange = onBlueChange,
                valueRange = 0f..255f,
            )
        }
        Text(
            text = "Color: (${red.toInt()},${green.toInt()},${blue.toInt()})",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(top = 12.dp, bottom = 12.dp).fillMaxWidth()
        )
        Box(
            modifier = Modifier
                .background(
                    // Para poner el color de fondo bien hay que pasarle los parametros en Int
                    Color(red.toInt(), green.toInt(), blue.toInt()),
                    shape = RoundedCornerShape(16.dp)) // Redondear las esquinas
                .fillMaxSize()
        ){}
    }

}