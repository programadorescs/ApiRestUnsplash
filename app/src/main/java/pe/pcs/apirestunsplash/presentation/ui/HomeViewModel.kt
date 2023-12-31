package pe.pcs.apirestunsplash.presentation.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pe.pcs.apirestunsplash.presentation.common.ResponseState
import pe.pcs.apirestunsplash.presentation.common.makeCall
import pe.pcs.apirestunsplash.domain.model.Photo
import pe.pcs.apirestunsplash.domain.usecase.getListUnsplashUseCase
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getListUnsplashUseCase: getListUnsplashUseCase
) : ViewModel() {

    private val _listPhoto = MutableLiveData<List<Photo>?>()
    val listPhoto: LiveData<List<Photo>?> = _listPhoto

    private val _stateList = MutableLiveData<ResponseState<List<Photo>>>()
    val stateList: LiveData<ResponseState<List<Photo>>> = _stateList

    fun getAllPhoto() {
        viewModelScope.launch {
            _stateList.value = ResponseState.Loading()

            makeCall {
                getListUnsplashUseCase()
            }.let {
                if (it is ResponseState.Success)
                    _listPhoto.value = it.data

                _stateList.value = it
            }
        }
    }

}