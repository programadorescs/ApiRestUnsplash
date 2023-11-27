package pe.pcs.apirestunsplash.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import pe.pcs.apirestunsplash.data.local.entity.UserEntity

@Dao
interface UserDao {
    @Insert
    suspend fun create(entity: UserEntity): Long

    @Query("Select id, name, nickname, password From user Where nickname=:nickname")
    suspend fun verifyNickname(nickname: String): UserEntity?

    @Query("Select id, name, nickname, password From user Where nickname=:nickname AND password=:password")
    suspend fun login(nickname: String, password: String): UserEntity?

    @Transaction
    suspend fun createTransaction(entity: UserEntity): Long {
        if(verifyNickname(entity.nickname) != null)
            throw Exception("El nickname ya existe en la db")

        return create(entity)
    }
}