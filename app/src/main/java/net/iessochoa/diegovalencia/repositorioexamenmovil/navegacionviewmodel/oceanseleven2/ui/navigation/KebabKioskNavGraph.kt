package net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.oceanseleven2.ui.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.oceanseleven2.ui.screens.OrderScreen
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.oceanseleven2.ui.screens.OrderScreenViewModel
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.oceanseleven2.ui.screens.SummaryScreen

@SuppressLint("ViewModelConstructorInComposable")
@Composable
fun KebabKioskNavGraph(
    navHostController: NavHostController,
    modifier: Modifier = Modifier
){

    val viewModel: OrderScreenViewModel = OrderScreenViewModel()

    val uiState by viewModel.uiState.collectAsState()

    NavHost(
        navController = navHostController,
        startDestination = OrderScreenDestination.route,
        modifier = modifier
    ){
        composable(route = OrderScreenDestination.route){
            OrderScreen(
                toppings = uiState.allToppings,
                selectedBread = uiState.pan,
                selectedMeat = uiState.carne,
                selectedToppings = uiState.selectedSalsasYExtras,
                onSelectedBreadChange = { viewModel.onSelectedBreadChange(it) },
                onSelectedMeatChange = { viewModel.onSelectedMeatChange(it) },
                onSelectedToppingsChange = { topping, isChecked -> viewModel.onSelectedToppingsChange(topping, isChecked) },
                onConfirmarPedido = { navHostController.navigate(SummaryScreenDestination.route) }
            )
        }

        composable(route = SummaryScreenDestination.route){
            SummaryScreen(
                pan = uiState.pan?.displayName,
                carne = uiState.carne?.displayName,
                salsasYExtras = uiState.selectedSalsasYExtras,
                totalPrice = uiState.totalPrice,
                onPayClick = { pagar(navHostController, viewModel) }
            )
        }
    }
}

private fun pagar(navHostController: NavHostController, viewModel: OrderScreenViewModel){
    viewModel.pagar()
    navHostController.popBackStack(OrderScreenDestination.route, inclusive = false)
}