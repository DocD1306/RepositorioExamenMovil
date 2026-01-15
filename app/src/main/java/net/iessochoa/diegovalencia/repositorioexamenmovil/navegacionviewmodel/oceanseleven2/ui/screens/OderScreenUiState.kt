package net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.oceanseleven2.ui.screens

import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.oceanseleven2.data.ToppingRepository
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.oceanseleven2.model.BreadType
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.oceanseleven2.model.MeatType
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.oceanseleven2.model.Topping

data class OrderScreenUiState(
    val pan: BreadType? = null,
    val carne: MeatType? = null,
    val selectedSalsasYExtras: List<Topping> = emptyList(),
    val allToppings: List<Topping> = ToppingRepository.getAllToppings(),
    val totalPrice: Double = 0.0
){}