package pe.pcs.apirestunsplash.domain.usecase

import pe.pcs.apirestunsplash.domain.model.Photo
import pe.pcs.apirestunsplash.domain.repository.UnsplashRepository
import javax.inject.Inject

class getListUnsplashUseCase @Inject constructor(
    private val repository: UnsplashRepository
) {

    suspend operator fun invoke(): List<Photo> {
        return repository.getList()
    }

}