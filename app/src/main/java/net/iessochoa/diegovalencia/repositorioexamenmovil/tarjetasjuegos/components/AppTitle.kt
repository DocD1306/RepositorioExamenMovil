package net.iessochoa.diegovalencia.repositorioexamenmovil.tarjetasjuegos.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import net.iessochoa.diegovalencia.repositorioexamenmovil.ui.theme.Typography

@Composable
fun AppTitle(title: String, modifier: Modifier = Modifier){
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            style = Typography.headlineLarge,
            fontWeight = FontWeight.Bold
        )
    }
}