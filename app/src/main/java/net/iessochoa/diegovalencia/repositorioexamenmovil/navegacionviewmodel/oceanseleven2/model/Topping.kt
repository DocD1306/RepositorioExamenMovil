package net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.oceanseleven2.model

import androidx.annotation.DrawableRes

data class Topping(
    val id: String,
    val name: String,
    val price: Double = 0.0,
    val allergens: List<AllergenType> = emptyList(),
    @param:DrawableRes val drawableRes: Int? = null
)