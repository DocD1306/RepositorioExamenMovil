package net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.propio1.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.propio1.datasource.PropioDataSource
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.propio1.model.PropioModel

data class PropioUiState(
    val currentPropioModelIndex: Int = 0,
    val currentPropioName: String = PropioDataSource.propioDataList[currentPropioModelIndex].name,
    val optionsList: List<PropioModel> = PropioDataSource.propioDataList
)