package pe.pcs.apirestunsplash.presentation.common

sealed class ResponseState<T> {
    class Loading<T> : ResponseState<T>()
    class Success<T>(val data: T) : ResponseState<T>()
    class Error<T>(val message: String) : ResponseState<T>()
}
