package pe.pcs.apirestunsplash.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import pe.pcs.apirestunsplash.data.utils.Constants
import pe.pcs.apirestunsplash.data.local.dao.PhotoDao
import pe.pcs.apirestunsplash.data.local.database.AppDatabase
import pe.pcs.apirestunsplash.data.remote.api.UnsplashApi
import pe.pcs.apirestunsplash.data.repository.UnsplashRepositoryImpl
import pe.pcs.apirestunsplash.data.utils.HeaderInterceptor
import pe.pcs.apirestunsplash.domain.repository.UnsplashRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InjectionModule {

    //******** Inyectando RETROFIT ********//

    @Singleton
    @Provides
    fun provideOkHttpClient(headerInterceptor: HeaderInterceptor): OkHttpClient {
        return OkHttpClient
            .Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addInterceptor(headerInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.URL_BASE)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideUnplashApi(retrofit: Retrofit): UnsplashApi {
        return retrofit.create(UnsplashApi::class.java)
    }

    @Singleton
    @Provides
    fun provideUnplashRepository(api: UnsplashApi, dao: PhotoDao): UnsplashRepository {
        return UnsplashRepositoryImpl(api, dao)
    }

    //******** Inyectando ROOM ********//

    private const val DATABASE_NAME = "photo_db"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME).build()
    }

    @Singleton
    @Provides
    fun providePhotoDao(db: AppDatabase): PhotoDao {
        return db.photoDao()
    }

}