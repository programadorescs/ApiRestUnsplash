package pe.pcs.apirestunsplash.data.repository

import pe.pcs.apirestunsplash.data.local.dao.UserDao
import pe.pcs.apirestunsplash.data.local.entity.toDatabase
import pe.pcs.apirestunsplash.domain.model.User
import pe.pcs.apirestunsplash.domain.model.toDomain
import pe.pcs.apirestunsplash.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImp @Inject constructor(
    private val dao: UserDao
): UserRepository {
    override suspend fun login(username: String, password: String): User? {
        return dao.login(username, password)?.toDomain()
    }

    override suspend fun create(user: User): Long {
        return dao.createTransaction(user.toDatabase())
    }
}