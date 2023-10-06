package pe.pcs.apirestunsplash.core

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.net.UnknownHostException

suspend fun <T> makeCall(
    call: suspend () -> T
): ResponseState<T> {
    return withContext(Dispatchers.IO) {
        try {
            ResponseState.Success(call())
        } catch (e: UnknownHostException) {
            // UnknownHostException -> Error de internet o red
            ResponseState.Error(e.message.toString())
        } catch (e: HttpException) {
            ResponseState.Error(e.message.toString())
        } catch (e: Exception) {
            ResponseState.Error(e.message.toString())
        }
    }
}