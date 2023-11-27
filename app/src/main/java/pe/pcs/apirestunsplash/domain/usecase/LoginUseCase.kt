package pe.pcs.apirestunsplash.domain.usecase

import pe.pcs.apirestunsplash.domain.model.User
import pe.pcs.apirestunsplash.domain.repository.UserRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke(nickname: String, password: String): User? {
        return repository.login(nickname, password)
    }
}