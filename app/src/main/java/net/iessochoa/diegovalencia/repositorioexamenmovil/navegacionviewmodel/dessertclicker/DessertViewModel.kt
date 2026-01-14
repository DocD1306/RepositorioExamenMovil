package net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.dessertclicker

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DessertViewModel : ViewModel(){

    private val _uiState = MutableStateFlow(UiState())

    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    fun updateRevenue(){

        val revenue = uiState.value.revenue
//        val currentDessertPrice = uiState.value.currentDessertPrice
        val dessertsSold = uiState.value.dessertsSold

//        _uiState.update { currentState ->
//            currentState.copy(
//                revenue = revenue + currentDessertPrice,
//                dessertsSold = dessertsSold + 1
//            )
//        }

        determineDessertToShow()
    }

    private fun determineDessertToShow() {
//        var dessertToShow = uiState.value.desserts.first()
        val dessertsSold = uiState.value.dessertsSold
        var dessertIndex = 0
//        for ((index, dessert) in uiState.value.desserts.withIndex()) {
//            if (dessertsSold >= dessert.startProductionAmount) {
//                dessertToShow = dessert
//                dessertIndex = index
//            } else {
//                // The list of desserts is sorted by startProductionAmount. As you sell more desserts,
//                // you'll start producing more expensive desserts as determined by startProductionAmount
//                // We know to break as soon as we see a dessert who's "startProductionAmount" is greater
//                // than the amount sold.
//                break
//            }
//        }
//
//        _uiState.update { currentState ->
//            currentState.copy(
//                currentDessertPrice = dessertToShow.price,
//                currentDessertIndex = dessertIndex,
//                currentDessertImageId = dessertToShow.imageId
//            )
//        }
    }

}