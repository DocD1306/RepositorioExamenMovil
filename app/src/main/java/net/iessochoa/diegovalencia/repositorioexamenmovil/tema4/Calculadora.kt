package net.iessochoa.diegovalencia.repositorioexamenmovil.tema4

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.iessochoa.diegovalencia.repositorioexamenmovil.R


@Preview (showBackground = true, showSystemUi = true)
@Composable
fun CalculadoraDisplay(modifier: Modifier = Modifier){

    // Variables de los OutlinedTextField con los numeros
    var number1 by rememberSaveable { mutableStateOf("") }
    var number2 by rememberSaveable { mutableStateOf("") }

    // Lista con los nombres de los botones
    var radioOptions = stringArrayResource(R.array.operaciones).toList()

    // Desestructuracion de la lista de nombres de los botones
    var (selectedOption, onOptionSelected) = remember {mutableStateOf(radioOptions[0])}

    // Convertimos las variables de los OutlinedTextField en numeros
    val number1N = number1.toDoubleOrNull() ?: 0.0
    val number2N = number2.toDoubleOrNull() ?: 0.0


    // Columna principal
    Column(
        modifier = modifier.padding(top = 40.dp, start = 40.dp, end = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Titulo de la calculadora
        Text(
            text = stringResource(R.string.title),
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.displaySmall,
            textAlign = TextAlign.Center
        )
        // Primer OutlinedTextField para el numero1
        UserInputField(
            label = R.string.label_input_field_1,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next // Ponemos Next para que salte al siguiente OutlinedTextField
            ),
            value = number1,
            onValueChange = { number1 = it },
            modifier = Modifier.fillMaxWidth()
        )
        // Segundo OutlinedTextField para el numero2
        UserInputField(
            label = R.string.label_input_field_2,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done // Ponemos done porque no hay mas OutlineTextField
            ),
            value = number2,
            onValueChange = { number2 = it },
            modifier = Modifier.fillMaxWidth()
        )
        // Metodo para crear los RadioButtons
        OperacionRadioButton(
            listaOperaciones = radioOptions,
            operacionSeleccionada = selectedOption,
            onOptionSelected = onOptionSelected,
            modifier = Modifier.fillMaxWidth()
        )
        // Mostar el titulo del resultado
        Text(
            text = stringResource(R.string.result_title),
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.displayMedium,
            textAlign = TextAlign.Center
        )
        // Mostrar el resultado de la operacion con los dos numeros de los OutlinedTextField
        ResultadoOperacion(
            operacion = selectedOption,
            numero1 = number1N,
            numero2 = number2N
        )
        // Mostrar el icono dependiendo de la operacion actual
        IconoOperacion(
            operacion = selectedOption
        )
    }

}

@Composable
fun UserInputField(
    @StringRes label: Int,
    keyboardOptions: KeyboardOptions,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(stringResource(label)) },
        keyboardOptions = keyboardOptions,
        modifier = modifier
    )
}

@Composable
fun OperacionRadioButton(
    listaOperaciones: List<String>,
    operacionSeleccionada: String,
    onOptionSelected: (String) -> Unit,
    modifier: Modifier = Modifier
){
    Row (
        modifier = modifier
            .selectableGroup()
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        listaOperaciones.forEach { option ->
            Row(
                modifier = Modifier
                    .selectable(
                        selected = (option == operacionSeleccionada),
                        onClick = { onOptionSelected(option) },
                        role = Role.RadioButton
                    ),
                verticalAlignment = Alignment.CenterVertically
            ){
                RadioButton(
                    selected = (option == operacionSeleccionada),
                    onClick = null
                )
                Text(
                    text = option,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

@Composable
fun ResultadoOperacion(
    operacion: String,
    numero1: Double,
    numero2: Double,
    modifier: Modifier = Modifier
){
    var resultado: Double

    when(operacion){
        // Utilizanmos un stringArrayResource para evitar que este hard coded a un solo idioma
        stringArrayResource(R.array.operaciones)[0] -> resultado = numero1 + numero2
        stringArrayResource(R.array.operaciones)[1] -> resultado = numero1 - numero2
        stringArrayResource(R.array.operaciones)[2] -> resultado = numero1 * numero2
        stringArrayResource(R.array.operaciones)[3] -> resultado = numero1 / numero2
        else -> resultado = 0.0
    }

    Text(
        text = resultado.toString(),
        style = MaterialTheme.typography.displayLarge,
        color = Color.Blue,
        modifier = modifier
    )

}

@Composable
fun IconoOperacion(
    operacion: String,
    modifier: Modifier = Modifier
){

    var imageVector: ImageVector

    when(operacion){
        // Utilizanmos un stringArrayResource para evitar que este hard coded a un solo idioma
        stringArrayResource(R.array.operaciones)[0] -> imageVector = Icons.Default.Add
        stringArrayResource(R.array.operaciones)[1] -> imageVector = Icons.Default.Face
        stringArrayResource(R.array.operaciones)[2] -> imageVector = Icons.Default.Clear
        stringArrayResource(R.array.operaciones)[3] -> imageVector = Icons.Default.FavoriteBorder
        else -> imageVector = Icons.Default.Warning
    }

    Icon(
        imageVector = imageVector,
        contentDescription = stringResource(R.string.operation_selected_description),
        modifier = Modifier.fillMaxSize()
    )
}