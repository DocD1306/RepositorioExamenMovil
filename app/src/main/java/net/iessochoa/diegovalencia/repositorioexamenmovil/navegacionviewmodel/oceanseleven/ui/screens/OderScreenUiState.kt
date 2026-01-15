package net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.oceanseleven.ui.screens

import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.oceanseleven.data.ToppingRepository
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.oceanseleven.model.BreadType
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.oceanseleven.model.MeatType
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.oceanseleven.model.Topping

data class OrderScreenUiState(
    val pan: BreadType = BreadType.PITA,
    val carne: MeatType = MeatType.BEEF,
    val selectedSalsasYExtras: List<Topping> = emptyList(),
    val allToppings: List<Topping> = ToppingRepository.getAllToppings(),
    val totalPrice: Double = pan.basePrice + selectedSalsasYExtras.sumOf { it.price }
){}