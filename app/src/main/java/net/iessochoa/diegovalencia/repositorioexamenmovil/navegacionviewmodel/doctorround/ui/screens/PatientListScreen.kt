package net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.doctorround.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.doctorround.DoctorViewModel
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.doctorround.ui.components.PatientListCard


@Composable
fun PatientListScreen(
    modifier: Modifier = Modifier,
    // TODO: TAREA 2 (MVVM) y TAREA 3 (Navegación) - Actualiza los parámetros:
    // 1. Añade el ViewModel para leer el estado (Tarea 2).
    doctorViewModel: DoctorViewModel,
    // 2. Añade la lambda para navegar al detalle: onPatientClick: () -> Unit (Tarea 3).
    onPatientClick: () -> Unit
) {
    // TODO: TAREA 2 - Migrar a MVVM
    // 1. BORRA la lectura directa del repositorio (línea de abajo).
    // 2. OBSERVA el estado del ViewModel (collectAsState) para obtener la lista de pacientes.
//    val patients = remember { PatientRepository.getPatients() } // <--- BORRAR ESTO

    val uiState by doctorViewModel.uiState.collectAsState()

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(uiState.patients) { patient ->
            PatientListCard(
                patient = patient,
                onClick = {
                    // TODO: TAREA 2 - Lógica de Selección
                    // - Avisa al ViewModel de qué paciente se ha seleccionado.
                    doctorViewModel.onPatientSelected(patient)
                    // TODO: TAREA 3 - Navegación
                    // - Ejecuta la lambda de navegación para ir al detalle.
                    onPatientClick()
                }
            )
        }
    }
}

