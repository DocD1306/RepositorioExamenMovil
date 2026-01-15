package net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.oceanseleven2.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.oceanseleven2.data.ToppingRepository
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.oceanseleven2.model.BreadType
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.oceanseleven2.model.MeatType
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.oceanseleven2.model.Topping
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.oceanseleven2.ui.components.BreadSelector
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.oceanseleven2.ui.components.MeatSelector
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.oceanseleven2.ui.components.ToppingList
import kotlin.collections.emptySet

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderScreen(
    toppings: List<Topping>,
    selectedBread: BreadType?,
    selectedMeat: MeatType?,
    selectedToppings: List<Topping>,
    onSelectedBreadChange: (BreadType) -> Unit,
    onSelectedMeatChange: (MeatType) -> Unit,
    onSelectedToppingsChange: (Topping, Boolean) -> Unit,
    onConfirmarPedido: () -> Unit,
    modifier: Modifier = Modifier
) {
//    // No es inyeccion de dependecias pero cumple
//    val toppings = ToppingRepository.getAllToppings()
//
//    // --- ESTADO HARDCODEADO ---
//    var selectedBread by remember { mutableStateOf(BreadType.PITA) }
//    var selectedMeat by remember { mutableStateOf(MeatType.MIXED) }
//    var selectedToppings by remember { mutableStateOf(emptySet<Topping>())}
//
//    // --- LOGICA DE NEGOCIO INCRUSTADA EN LA UI ---
//    // Calculamos el precio en cada recomposicion
//    val breadPrice = selectedBread.basePrice
//    val toppingsPrice = selectedToppings.sumOf { it.price }
//    val totalPrice = breadPrice + toppingsPrice

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        // 1. SECCION PAN
        SectionTitle("1. Elige tu pan")
        BreadSelector(
            breads = BreadType.entries,
            selectedBread = selectedBread,
            onBreadSelected = { newBread ->
                onSelectedBreadChange(newBread)
            }
        )

        Spacer(modifier = Modifier.padding(top=16.dp))
        HorizontalDivider()
        Spacer(modifier = Modifier.padding(top=16.dp))


        //2. SECCION CARNE
        SectionTitle("2. Elige la Carne")
        MeatSelector(
            meats = MeatType.entries,
            selectedMeat = selectedMeat,
            onMeatSelected = { newMeat ->
                onSelectedMeatChange(newMeat)
            }
        )

        Spacer(modifier = Modifier.padding(top=16.dp))
        HorizontalDivider()
        Spacer(modifier = Modifier.padding(top=16.dp))

        //3. SECCION SALSAS Y EXTRAS
        SectionTitle("3. Salsas y Extras")
        ToppingList(
            selectedToppings = selectedToppings.toSet(),
            toppings = toppings,
            onToppingToggled = { topping, isChecked ->
                onSelectedToppingsChange(topping, isChecked)
            }
        )

        Spacer(modifier = Modifier.padding(top=16.dp))
        HorizontalDivider()
        Spacer(modifier = Modifier.padding(top=16.dp))

        Button(
            onClick = onConfirmarPedido,
        ) {
            Text("Confirmar Pedido")
        }
    }
}

@Composable
private fun SectionTitle(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.headlineSmall,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(bottom = 8.dp)
    )
}