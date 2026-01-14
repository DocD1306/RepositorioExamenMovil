package net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.doctorround.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.doctorround.model.Patient


@Composable
fun PatientSummaryCard(
    patient: Patient,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        // TODO: TAREA 1 DE DISEÑO (UI)
        // El diseño actual es vertical (Column), pero el diseño requerido es HORIZONTAL:
        // [FOTO] - [DATOS DEL PACIENTE] - [ICONO ESTADO]

        // 1. Cambia este Column por un Row.
        // 2. Alinea el contenido verticalmente al centro (verticalAlignment).
        Column(
            modifier = Modifier.padding(8.dp)
        ) {

            // --- 1. FOTO (Izquierda) ---
            Image(
                painter = painterResource(patient.imageResId),
                modifier = Modifier
                    .size(80.dp) // Ajusta el tamaño si es necesario
                    .clip(shape = CircleShape),
                contentDescription = "Foto de perfil del paciente"
            )

            // --- 2. DATOS (Centro) ---
            // TODO: Esta columna debe ocupar todo el espacio disponible entre la foto y el icono.
            // PISTA: Usa el .weight(1f) y añade un padding start para separarlo de la foto.
            Column(
                modifier = Modifier.padding(vertical = 8.dp) // Ajusta este modifier
            ) {
                // TODO: Muestra los datos reales del objeto 'patient'
                Text(
                    text = patient.fullName, // Ya corregido para que no pierdan tiempo
                )
                Text(
                    text = "Habitación: [Poner valor aquí]" // TODO: Bindear patient.room
                )
                Text(
                    text = "ID: [Poner valor aquí]" // TODO: Bindear patient.id
                )
            }

            // --- 3. ICONO ESTADO (Derecha) ---
            // Este componente ya se te da hecho, solo tienes que ubicarlo bien en el Row.
            PatientConditionIcon(patient)
        }
    }
}
