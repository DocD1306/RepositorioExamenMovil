package net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.oceanseleven.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.oceanseleven.model.BreadType
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.oceanseleven.model.MeatType
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.oceanseleven.model.Topping

class OrderScreenViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(OrderScreenUiState())

    val uiState: StateFlow<OrderScreenUiState> = _uiState.asStateFlow()

    fun onSelectedBreadChange(bread: BreadType){
        _uiState.update { currentState ->
            currentState.copy(
                pan = bread,
                totalPrice = bread.basePrice + currentState.selectedSalsasYExtras.sumOf { it.price }
            )
        }
    }

    fun onSelectedMeatChange(meat: MeatType){
        _uiState.update { currentState ->
            currentState.copy(
                carne = meat
            )
        }
    }

    fun onSelectedToppingsChange(topping: Topping, isChecked: Boolean){

        _uiState.update { currentState ->

            val newSelectedSalsasYExtras = if (!isChecked) {
                currentState.selectedSalsasYExtras - topping
            } else {
                currentState.selectedSalsasYExtras + topping
            }

            currentState.copy(
                selectedSalsasYExtras = newSelectedSalsasYExtras,
                totalPrice = currentState.pan.basePrice + newSelectedSalsasYExtras.sumOf { it.price }
            )
        }
    }

    fun pagar(){
        _uiState.update { currentState ->
            currentState.copy(
                pan = BreadType.PITA,
                carne = MeatType.BEEF,
                selectedSalsasYExtras = emptyList(),
                totalPrice = 0.0
            )
        }
    }

}