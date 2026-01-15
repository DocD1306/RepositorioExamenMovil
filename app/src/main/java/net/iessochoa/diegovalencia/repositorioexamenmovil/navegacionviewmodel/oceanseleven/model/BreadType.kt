package net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.oceanseleven.model

import androidx.annotation.DrawableRes
import net.iessochoa.diegovalencia.repositorioexamenmovil.R

enum class BreadType(
    val id: String,
    val displayName: String,
    @param:DrawableRes val icon: Int,
    val basePrice: Double
){
    PITA("pita", "Pita", R.drawable.geralt, 4.00),
    DURUM("durum", "Durum", R.drawable.triss, 4.50)
}