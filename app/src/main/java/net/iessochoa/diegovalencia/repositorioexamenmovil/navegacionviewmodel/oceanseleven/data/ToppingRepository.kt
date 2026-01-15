package net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.oceanseleven.data

import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.oceanseleven.model.AllergenType
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.oceanseleven.model.Topping
import kotlin.random.Random

object ToppingRepository {
    private val toppings = listOf(
        Topping(
            id = "white_sauce",
            name = "Salsa Blanca",
            price = 0.0,
            allergens = listOf(
                AllergenType.DAIRY
            )
        ),
        Topping(
            id = "red_sauce",
            name = "Salsa Roja",
            price = 0.0,
            allergens = listOf(
                AllergenType.SPICY
            )
        ),
        Topping(
            id = "eggs",
            name = "Huevo",
            price = 0.50,
            allergens = listOf(
                AllergenType.EGG
            )
        ),
        Topping(
            id = "pistachios",
            name = "Pistachos",
            price = 1.20,
            allergens = listOf(
                AllergenType.NUTS
            )
        ),
        Topping(
            id = "prawns",
            name = "Gambas",
            price = 2.00,
            allergens = listOf(
                AllergenType.SEAFOOD
            )
        )
    )

    fun getAllToppings(): List<Topping> = toppings.toList()

    fun getRandomTopping(): Topping = toppings[Random.nextInt(toppings.size)]
}