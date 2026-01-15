package net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.oceanseleven.ui.navigation

import net.iessochoa.diegovalencia.repositorioexamenmovil.R

object OrderScreenDestination: NavigationDestination {
    override val route: String
        get() = "order_screen_destination"
    override val title: Int
        get() = R.string.order_screen_title

}

object SummaryScreenDestination: NavigationDestination {
    override val route: String
        get() = "summary_screen_destination"
    override val title: Int
        get() = R.string.summary_screen_title

}