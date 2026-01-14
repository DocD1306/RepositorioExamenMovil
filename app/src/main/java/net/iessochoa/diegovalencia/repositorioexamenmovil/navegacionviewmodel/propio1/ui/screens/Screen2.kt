package net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.propio1.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.propio1.model.PropioModel
import kotlin.collections.forEach

@Composable
fun Screen2(
    onNextButtonClicked: () -> Unit,
    onCancelButtonClicked: () -> Unit,
    onChangeSelectedOption: (PropioModel) -> Unit,
    optionsList: List<PropioModel>,
    selectedOption: PropioModel,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Pantalla 2"
        )

        Spacer(modifier.padding(vertical = 8.dp))

        Row(
            modifier = modifier
                .fillMaxWidth()
                .selectableGroup()
                .padding(all = 30.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            optionsList.forEach { option ->
                Row(
                    modifier = Modifier
                        .weight(1f)
                        .selectable(
                            selected = option == selectedOption,
                            onClick = { onChangeSelectedOption(option) },
                            role = Role.RadioButton
                        )
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = option == selectedOption,
                        onClick = null
                    )
                    Text (
                        text = option.name,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }

        Spacer(modifier.padding(vertical = 8.dp))

        Button(
            onClick = onNextButtonClicked
        ) {
            Text(
                text = "Siguiente"
            )
        }
        Spacer(modifier.padding(vertical = 8.dp))

        Button(
            onClick = onCancelButtonClicked
        ) {
            Text(
                text = "Cancelar"
            )
        }

    }
}