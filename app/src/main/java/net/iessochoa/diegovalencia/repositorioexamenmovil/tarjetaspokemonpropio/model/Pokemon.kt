package net.iessochoa.diegovalencia.repositorioexamenmovil.tarjetaspokemonpropio.model
import androidx.annotation.DrawableRes

data class Pokemon (
    val nombre: String,
    @DrawableRes val image: Int,
    var rating: Int
)