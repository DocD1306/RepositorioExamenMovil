package net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.propio1.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.propio1.datasource.PropioDataSource
import net.iessochoa.diegovalencia.repositorioexamenmovil.navegacionviewmodel.propio1.model.PropioModel

class PropioViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(PropioUiState())

    val uiState: StateFlow<PropioUiState> = _uiState.asStateFlow()


    fun changeOptionSelected(option: PropioModel){

        var newIndex: Int = 0

        for((index, model) in PropioDataSource.propioDataList.withIndex()){
            if (model == option){
                newIndex = index
            }
        }

        _uiState.update { currentState ->
            currentState.copy(
                currentPropioModelIndex = newIndex
            )
        }

    }

    fun clearViewModel(){
        _uiState.update { currentState ->
            currentState.copy(
                currentPropioModelIndex = 0
            )
        }
    }

}