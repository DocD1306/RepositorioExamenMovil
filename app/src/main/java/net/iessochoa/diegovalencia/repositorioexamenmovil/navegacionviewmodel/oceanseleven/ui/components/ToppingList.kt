package net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.oceanseleven.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.oceanseleven.model.Topping

@Composable
fun ToppingList(
    toppings: List<Topping>,
    selectedToppings: Set<Topping>,
    // CAMBIO IMPORTANTE: Ahora pasamos el Topping Y el estado (Boolean)
    onToppingToggled: (Topping, Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(horizontal = 16.dp)) {
        toppings.forEach { topping ->
            // Verificamos si este topping está en la lista de seleccionados
            val isChecked = selectedToppings.contains(topping)

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 2.dp)
                    .clip(MaterialTheme.shapes.small)
                    // Al hacer click en la fila completa, invertimos el valor actual (!isChecked)
                    .clickable { onToppingToggled(topping, !isChecked) }
                    .padding(end = 8.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = isChecked,
                        // Al hacer click en el checkbox, pasamos el nuevo valor (checked)
                        onCheckedChange = { newCheckedState ->
                            onToppingToggled(topping, newCheckedState)
                        }
                    )
                    Text(
                        text = topping.name,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }

                if (topping.price > 0) {
                    Text(
                        text = "+ ${topping.price} €",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}