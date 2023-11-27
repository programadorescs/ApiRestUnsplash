package pe.pcs.apirestunsplash.presentation.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pe.pcs.apirestunsplash.domain.model.User
import pe.pcs.apirestunsplash.domain.usecase.LoginUseCase
import pe.pcs.apirestunsplash.presentation.common.ResponseState
import pe.pcs.apirestunsplash.presentation.common.makeCall
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {
    private val _uiState = MutableLiveData<ResponseState<User?>>()
    val uiState: LiveData<ResponseState<User?>> = _uiState

    fun getLogin(nickname: String, password: String) {
        viewModelScope.launch {
            _uiState.value = ResponseState.Loading()

            makeCall {
                loginUseCase(nickname, password)
            }.let {
                _uiState.value = it
            }
        }
    }
}