package pe.pcs.apirestunsplash.presentation.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pe.pcs.apirestunsplash.domain.model.User
import pe.pcs.apirestunsplash.domain.usecase.CreateUserUseCase
import pe.pcs.apirestunsplash.presentation.common.ResponseState
import pe.pcs.apirestunsplash.presentation.common.makeCall
import javax.inject.Inject

@HiltViewModel
class CrearCuentaViewModel @Inject constructor(
    private val createUserUseCase: CreateUserUseCase
) : ViewModel() {
    private val _uiState = MutableLiveData<ResponseState<Int>>()
    val uiState: LiveData<ResponseState<Int>> = _uiState

    fun setCreateUser(user: User) {
        viewModelScope.launch {
            _uiState.value = ResponseState.Loading()

            makeCall {
                createUserUseCase(user)
            }.let {
                _uiState.value = it
            }
        }
    }
}