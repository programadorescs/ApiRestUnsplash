package pe.pcs.apirestunsplash.domain.repository

import pe.pcs.apirestunsplash.domain.model.User

interface UserRepository {
    suspend fun login(username: String, password: String): User?

    suspend fun create(user: User): Long
}