package pe.pcs.apirestunsplash.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import pe.pcs.apirestunsplash.domain.model.User

@Entity(
    tableName = "user",
    indices = [Index(value = ["nickname"], unique = true)]
)
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id") var id: Int = 0,
    @ColumnInfo("name") var name: String = "",
    @ColumnInfo("nickname") var nickname: String = "",
    @ColumnInfo("password") var password: String = ""
)

fun User.toDatabase() = UserEntity(
    id = id,
    name = name,
    nickname = nickname,
    password = password
)