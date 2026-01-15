package net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.oceanseleven.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.oceanseleven.model.BreadType

@Composable
fun BreadSelector(
    breads: List<BreadType>,
    selectedBread: BreadType?,
    onBreadSelected: (BreadType) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(breads) { bread ->
            BreadCard(
                bread = bread,
                selected = (bread == selectedBread),
                onClick = { onBreadSelected(bread) }
            )
        }
    }
}