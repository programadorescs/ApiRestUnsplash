package pe.pcs.apirestunsplash.domain.model

import pe.pcs.apirestunsplash.data.local.entity.UserEntity

data class User(
    var id: Int = 0,
    var name: String = "",
    var nickname: String = "",
    var password: String = ""
)

fun UserEntity.toDomain() = User(
    id = id,
    name = name,
    nickname = nickname,
    password = password
)