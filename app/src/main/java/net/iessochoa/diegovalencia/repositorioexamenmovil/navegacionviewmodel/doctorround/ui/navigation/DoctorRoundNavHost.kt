package net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.doctorround.ui.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.doctorround.DoctorViewModel
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.doctorround.ui.screens.PatientDetailScreen
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.doctorround.ui.screens.PatientListScreen


// Añade aquí tus imports necesarios (NavHost, composable, tus screens, tu ViewModel...)

/**
 * Grafo de navegación de la aplicación.
 * Aquí se define qué pantalla se muestra para cada ruta.
 */
@SuppressLint("ViewModelConstructorInComposable")
@Composable
fun DoctorRoundNavHost(
    // 1. navController (NavHostController)
    navController: NavHostController,
    // 2. viewModel (DoctorViewModel) - Para compartir el estado entre pantallas
    modifier: Modifier = Modifier,
) {
    // TODO: TAREA 3 - Implementa el NavHost
    // - Define el startDestination usando tu objeto PatientListDestination
    // - Define los dos composables:
    //      1. PatientListDestination.route -> Muestra PatientListScreen
    //      2. PatientDetailDestination.route -> Muestra PatientDetailScreen
    val doctorViewModel: DoctorViewModel = DoctorViewModel()

    NavHost(
        navController = navController,
        startDestination = PatientListDestination.route,
        modifier = modifier
    ){
        composable(PatientListDestination.route){
            PatientListScreen(
                doctorViewModel = doctorViewModel,
                onPatientClick = { navController.navigate(PatientDetailDestination.route) }
            )
        }
        composable(PatientDetailDestination.route){
            PatientDetailScreen(
                doctorViewModel = doctorViewModel,
                onBack = { navController.navigateUp() }
            )
        }
    }

    /* PISTA: Recuerda usar el Navigation Helper si te atascas */
}