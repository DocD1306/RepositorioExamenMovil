package net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.doctorround

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.doctorround.ui.navigation.DoctorRoundNavHost
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.doctorround.ui.navigation.PatientDetailDestination
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.doctorround.ui.navigation.PatientListDestination


@SuppressLint("ViewModelConstructorInComposable")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
        /* TODO: Modifica esta clase para terminar de implementar la navegación */
fun DoctorRoundApp(
    navController: NavHostController = rememberNavController()
) {

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route
    val currentScreenTitle = when (currentRoute){
        PatientListDestination.route -> stringResource(PatientListDestination.titleRes)
        PatientDetailDestination.route -> stringResource(PatientDetailDestination.titleRes)
        else -> stringResource(PatientListDestination.titleRes)
    }

    Scaffold(
        topBar = {
            DoctorTopAppBar(
                title = currentScreenTitle,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
        // Aquí es donde el alumno implementará más tarde el NavHost
        // De momento, mostramos la lista directamente para que tengan algo visual
        DoctorRoundNavHost(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DoctorTopAppBar(
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    title: String,
    modifier: Modifier = Modifier,
){
    TopAppBar(
        title = { Text(title) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
        ),
        navigationIcon = {
            if(canNavigateBack){
                IconButton(
                    onClick = navigateUp
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null
                    )
                }
            }
        },
        modifier = modifier
    )
}
