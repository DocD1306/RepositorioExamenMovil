package net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.doctorround.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.doctorround.DoctorViewModel
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.doctorround.ui.components.PatientDiagnosis
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.doctorround.ui.components.PatientSummaryCard
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.doctorround.ui.components.PatientSymptomatology


@Composable
fun PatientDetailScreen(
    // TODO: TAREA 2 y 3 - Modificar Argumentos para MVVM y Navegación
    // 1. Elimina 'patient'. La pantalla debe obtener los datos del ViewModel.
    // 2. Añade 'doctorViewModel: DoctorViewModel'.
    // 3. Añade 'onBack: () -> Unit' para la navegación.
    //patient: Patient,
    doctorViewModel: DoctorViewModel,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {

    // TODO: TAREA 1 y 4 - Estado y Eventos con MVVM
    // 1. Obtén el 'uiState' del ViewModel.
    // 2. Define el paciente a mostrar: uiState.value.selectedPatient (o uno por defecto si es null).
    // 3. Define las lambdas para los eventos:
    //    - onPainValueChange: llama a viewModel.onPainLevelChanged
    //    - onNoteValueChange: llama a viewModel.onNoteChanged

    val uiState by doctorViewModel.uiState.collectAsState()

    val notNullPatient = uiState.patients.first()

    val scrollState = rememberScrollState()
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
            .fillMaxSize()
            .padding(16.dp)
    )  {

        // TODO 1: Mejora el estilo de este texto (usa MaterialTheme o un componente personalizado como DetailSectionTitle)
        Text("Datos Identificativos")

        // TODO 1: Implementa correctamente este componente
        PatientSummaryCard(uiState.selectedPatient ?: notNullPatient)

        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

        // TODO 1: Mejora el estilo de este texto (usa MaterialTheme o un componente personalizado como DetailSectionTitle)
        Text("Sintomatología")

        PatientSymptomatology(uiState.selectedPatient ?: notNullPatient)

        // TODO 1: Mejora el estilo de este texto (usa MaterialTheme o un componente personalizado como DetailSectionTitle)
        Text("Diagnóstico")

        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

        // TODO: Este componente se entrega ya implementado, solo tienes que llamarlo con los parámetros adecuados.
        PatientDiagnosis(patient = uiState.selectedPatient ?: notNullPatient, onValueChange = {})

        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))


        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { /* TODO: Actualizar los datos */ }
        ) {
            Text("Actualizar")
        }



    }

}

