package net.iessochoa.diegovalencia.repositorioexamenmovil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import net.iessochoa.diegovalencia.repositorioexamenmovil.listasscrolleables.AffirmationsApp
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.doctorround.DoctorRoundApp
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.propio1.Propio1
import net.iessochoa.diegovalencia.repositorioexamenmovil.otros.AppChuletaSergio
import net.iessochoa.diegovalencia.repositorioexamenmovil.tarjetasjuegos.MainScreen
import net.iessochoa.diegovalencia.repositorioexamenmovil.tarjetaspokemonpropio.composables.DisplayCards
import net.iessochoa.diegovalencia.repositorioexamenmovil.tema4.CalculadoraDisplay
import net.iessochoa.diegovalencia.repositorioexamenmovil.tema4.TipTimeLayout
import net.iessochoa.diegovalencia.repositorioexamenmovil.tema5.Ejercicio3
import net.iessochoa.diegovalencia.repositorioexamenmovil.tema5.PizzaDisplay
import net.iessochoa.diegovalencia.repositorioexamenmovil.tema5.SliderColores
import net.iessochoa.diegovalencia.repositorioexamenmovil.ui.theme.RepositorioExamenMovilTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RepositorioExamenMovilTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    App(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun App(
    modifier: Modifier = Modifier
){
    // Tema 4
    //TipTimeLayout() // Ejercicio1 - Calculador de propina
    //CalculadoraDisplay() // Ejercicio 3 - Calculadora con iconos

    // Tema 5
    //PizzaDisplay() // Ejercicio 1 - Checks con imagenes y precio que cambia
    //SliderColores() // Ejercicio 2 - Sliders con color de fondo
    //Ejercicio3() // Ejercicio 3 - Desplegable que cambia entre ejercicios

    // Otros
    //MainScreen() // Cartas de videojuegos con rating
    //AppChuletaSergio("Chuleta Sergio") // Wombo combo de sergio
    //AffirmationsApp() // Afirmaciones google
    // DisplayCards() // Cartas pokemon Diego

    // Navegación y ViewModel
    // Propio1()
    //DoctorRoundApp()
}