package net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.propio1

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.propio1.model.PropioModel
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.propio1.ui.PropioViewModel
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.propio1.ui.screens.Screen1
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.propio1.ui.screens.Screen2
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.propio1.ui.screens.Screen3
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.propio1.ui.screens.StartScreen


enum class Screens(name: String){
    START("Start"),
    SCREEN1("Screen 1"),
    SCREEN2("Screen 2"),
    SCREEN3("Screen 3")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun topAppBar(
    title: String,
    onClick: () -> Unit,
    canNavigateBack: Boolean,
    modifier: Modifier = Modifier
){
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            if (canNavigateBack){
                IconButton( onClick = onClick ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Localized description"
                    )
                }
            }
        }
    )
}

@Composable
fun Propio1(
    propioViewModel: PropioViewModel = viewModel(),
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
){

    val backStackEntry by navController.currentBackStackEntryAsState()

    val currentScreen = Screens.valueOf(
        backStackEntry?.destination?.route ?: Screens.START.name
    )

    val uiState by propioViewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            topAppBar(
                title = currentScreen.name,
                onClick = { navController.navigateUp() },
                canNavigateBack = navController.previousBackStackEntry != null
            )
        }
    ) { innerPadding ->
        NavHost (
            navController = navController,
            startDestination = Screens.START.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = Screens.START.name) {
                StartScreen(
                    onNextButtonClicked = { navController.navigate(Screens.SCREEN1.name) }
                )
            }
            composable(route = Screens.SCREEN1.name) {
                Screen1(
                    onNextButtonClicked = { navController.navigate(Screens.SCREEN2.name) },
                    onCancelButtonClicked = { cancelNavigation(navController, propioViewModel) },
                    onChangeSelectedOption = { propioViewModel.changeOptionSelected(it) },
                    optionsList = uiState.optionsList,
                    selectedOption = uiState.optionsList[uiState.currentPropioModelIndex]
                )
            }
            composable(route = Screens.SCREEN2.name) {
                Screen2(
                    onNextButtonClicked = { navController.navigate(Screens.SCREEN3.name) },
                    onCancelButtonClicked = { cancelNavigation(navController, propioViewModel) },
                    onChangeSelectedOption = { propioViewModel.changeOptionSelected(it) },
                    optionsList = uiState.optionsList,
                    selectedOption = uiState.optionsList[uiState.currentPropioModelIndex]
                )
            }
            composable(route = Screens.SCREEN3.name) {
                Screen3(
                    onCancelButtonClicked = { cancelNavigation(navController, propioViewModel) },
                    onChangeSelectedOption = { propioViewModel.changeOptionSelected(it) },
                    optionsList = uiState.optionsList,
                    selectedOption = uiState.optionsList[uiState.currentPropioModelIndex]
                )
            }
        }
    }
}

fun cancelNavigation(navController: NavHostController, propioViewModel: PropioViewModel){
    propioViewModel.clearViewModel()
    navController.popBackStack(Screens.START.name, inclusive = false)
}