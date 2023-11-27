package pe.pcs.apirestunsplash.domain.usecase

import pe.pcs.apirestunsplash.domain.model.User
import pe.pcs.apirestunsplash.domain.repository.UserRepository
import javax.inject.Inject

class CreateUserUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke(user: User): Int {
        return repository.create(user).toInt()
    }
}