package net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.oceanseleven.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import net.iessochoa.diegovalencia.repositorioexamenmovil.R
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.oceanseleven.model.AllergenType

@Composable
fun AllergensBar(
    allergens: List<AllergenType>,
    modifier: Modifier = Modifier
){
    if (allergens.isNotEmpty()){
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            Text(
                text = "Alergenos",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                allergens.forEach { allergen ->
                    AllergenIcon(allergen = allergen)
                }
            }
        }
    }
}

@Composable
private fun AllergenIcon(allergen: AllergenType){
    val (icon, label, color) = when (allergen) {
        AllergenType.DAIRY -> Triple(
            painterResource(R.drawable.e911_emergency_24px),
            "Lacteos",
            Color(0xFF64D5F6)
        )
        AllergenType.SPICY -> Triple(
            painterResource(R.drawable.thumb_up_24px),
            "Picante",
            Color(0xFF64D5F6)
        )
        AllergenType.EGG -> Triple(
            painterResource(R.drawable.question_mark_24px),
            "Huevo",
            Color(0xFF64D5F6)
        )
        AllergenType.NUTS -> Triple(
            painterResource(R.drawable.yennefer),
            "Nuts",
            Color(0xFF64D5F6)
        )
        AllergenType.SEAFOOD -> Triple(
            painterResource(R.drawable.thumb_up_24px),
            "Seafood",
            Color(0xFF64D5F6)
        )
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally){
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(color.copy(alpha = 0.2f))
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ){
            Image(
                painter = icon,
                contentDescription = label,
                modifier = Modifier.size(20.dp)
            )
        }
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}
