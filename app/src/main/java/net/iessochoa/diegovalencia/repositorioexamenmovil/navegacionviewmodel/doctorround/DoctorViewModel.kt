package net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.doctorround

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.doctorround.data.PatientRepository
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.doctorround.model.Patient


class DoctorViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(DoctorUiState())
    val uiState: StateFlow<DoctorUiState> = _uiState.asStateFlow()

    // Bloque de inicialización para cargar los pacientes
    init {
        _uiState.update { currentState ->
            currentState.copy(
                patients = PatientRepository.getPatients()
            )
        }
    }

    fun onPatientSelected(patient: Patient) {

        _uiState.update { currentState ->
            currentState.copy(
                selectedPatient = patient
            )
        }

    }

    fun onNoteChanged(newNote: String) {

        _uiState.update { currentState ->
            currentState.copy(
                selectedPatient = currentState.selectedPatient?.copy(visitNote = newNote)
            )
        }

    }

    fun onPainLevelChanged(newLevel: Float) {

        _uiState.update { currentState ->
            currentState.copy(
                selectedPatient = currentState.selectedPatient?.copy(painLevel = newLevel)
            )
        }

    }

    fun onVisitSaved() {

        val modifierPatient = _uiState.value.selectedPatient

        if(modifierPatient != null){
            PatientRepository.updatePatient(modifierPatient)

            _uiState.update { currentState ->
                currentState.copy(
                    patients = PatientRepository.getPatients().toList()
                )
            }
        }

    }
}