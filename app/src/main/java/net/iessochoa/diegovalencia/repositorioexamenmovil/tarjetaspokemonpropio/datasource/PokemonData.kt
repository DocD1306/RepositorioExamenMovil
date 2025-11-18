package net.iessochoa.diegovalencia.repositorioexamenmovil.tarjetaspokemonpropio.datasource

import net.iessochoa.diegovalencia.repositorioexamenmovil.R
import net.iessochoa.diegovalencia.repositorioexamenmovil.tarjetaspokemonpropio.model.Pokemon


fun getPokemonddData(): List<Pokemon>{

    return listOf(
        Pokemon("Turtwig", R.drawable.turtwig, 0),
        Pokemon("Regigigas", R.drawable.regigigas, 0),
        Pokemon("Golurk", R.drawable.golurk, 0),

        )
}

