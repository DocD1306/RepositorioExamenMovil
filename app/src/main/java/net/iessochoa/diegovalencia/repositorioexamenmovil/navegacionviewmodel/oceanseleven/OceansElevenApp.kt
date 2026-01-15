package net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.oceanseleven

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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import net.iessochoa.diegovalencia.repositorioexamenmovil.R
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.oceanseleven.ui.navigation.KebabKioskNavGraph
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.oceanseleven.ui.navigation.OrderScreenDestination
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.oceanseleven.ui.navigation.SummaryScreenDestination
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.oceanseleven.ui.screens.OrderScreen
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.oceanseleven.ui.screens.OrderScreenViewModel

@Composable
fun OceansElevenApp(navController: NavHostController = rememberNavController()){

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    val currentTitle = when(currentRoute){
        OrderScreenDestination.route -> OrderScreenDestination.title
        SummaryScreenDestination.route -> SummaryScreenDestination.title
        else -> OrderScreenDestination.title
    }

    Scaffold(
        topBar = {
            OceansTopAppBar(
                title = stringResource(currentTitle),
                onClick = { navController.navigateUp() },
                canNavigateBack = navController.previousBackStackEntry != null
            )
        }
    ) { paddingValues ->
        KebabKioskNavGraph(
            navHostController = navController,
            modifier = Modifier.padding(paddingValues)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OceansTopAppBar(
    title: String,
    canNavigateBack: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            if(canNavigateBack){
                IconButton(
                    onClick = { onClick() }
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