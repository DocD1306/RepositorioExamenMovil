package net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.oceanseleven2.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.oceanseleven2.model.BreadType
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.oceanseleven2.model.Topping
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.oceanseleven2.ui.components.AllergensBar

@Composable
fun SummaryScreen(
    pan: String?,
    carne: String?,
    salsasYExtras: List<Topping>,
    totalPrice: Double,
    onPayClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    // 1. Lógica de Precio:
    // Como recibimos 'pan' como String ("Pan de pita"), buscamos en el Enum BreadType
    // alguno que coincida o esté contenido en el nombre para sacar su precio base.
//    val breadPrice = BreadType.entries.find {
//        pan.contains(it.displayName, ignoreCase = true) || it.displayName.equals(pan, ignoreCase = true)
//    }?.basePrice ?: 0.0
//
//    val extrasPrice = salsasYExtras.sumOf { it.price }
//    val totalPrice = breadPrice + extrasPrice

    // 2. Lógica de Alérgenos:
    // Extraemos todos los alérgenos de los toppings y quitamos repetidos
    val allAllergens = salsasYExtras.flatMap { it.allergens }.distinct()

    Scaffold(
        modifier = modifier,
        bottomBar = {
            BottomOrderBar(
                total = totalPrice,
                onPayClick = { onPayClick() }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()) // Scroll por si hay muchos extras
        ) {
            // --- TARJETA RESUMEN ---
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFF2F4F7) // Gris claro similar a la foto
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = "Resumen de tu Pedido",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black.copy(alpha = 0.7f)
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    SummaryItem(label = "Pan", value = pan)
                    SummaryItem(label = "Carne", value = carne)

                    // Convertimos la lista de objetos Topping a un String separado por comas
                    val extrasText = if (salsasYExtras.isNotEmpty()) {
                        salsasYExtras.joinToString(", ") { it.name }
                    } else {
                        "Sin extras"
                    }
                    SummaryItem(label = "Salsas y extras", value = extrasText)
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // --- BARRA DE ALÉRGENOS ---
            if (allAllergens.isNotEmpty()) {
                Text(
                    text = "Alérgenos e intolerancias",
                    style = MaterialTheme.typography.labelLarge,
                    color = Color.Gray,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(bottom = 8.dp, start = 4.dp)
                )
                // Llamamos a tu componente existente AllergenBar
                AllergensBar(allergens = allAllergens)
            }
        }
    }
}

// --- COMPONENTES AUXILIARES (Basados en tus capturas) ---

@Composable
fun SummaryItem(label: String, value: String?) {
    // Usamos buildAnnotatedString para que "Etiqueta:" sea negrita y el valor normal
    Text(
        text = buildAnnotatedString {
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Gray)) {
                append("$label: ")
            }
            withStyle(style = SpanStyle(fontWeight = FontWeight.Normal, color = Color.Gray)) {
                append(value)
            }
        },
        fontSize = 16.sp
    )
}

@Composable
fun BottomOrderBar(
    total: Double,
    onPayClick: () -> Unit
) {
    // Tarjeta blanca con sombra y esquinas superiores redondeadas
    Card(
        shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "TOTAL",
                    style = MaterialTheme.typography.labelMedium,
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp
                )
                Text(
                    text = String.format("%.2f€", total), // Formato 6,40€
                    style = MaterialTheme.typography.headlineLarge,
                    color = Color(0xFF7D8CA3), // Color azul/grisáceo de tu foto
                    fontWeight = FontWeight.Bold
                )
            }

            Button(
                onClick = onPayClick,
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                modifier = Modifier.height(50.dp)
            ) {
                Text(
                    text = "PAGAR",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
        }
    }
}