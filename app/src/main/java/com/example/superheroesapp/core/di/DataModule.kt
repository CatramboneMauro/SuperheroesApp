package com.example.superheroesapp.core.di

import android.app.Application
import androidx.room.Room
import com.example.superheroesapp.data.local.SuperHeroesDatabase
import com.example.superheroesapp.data.remote.service.MarvelApiService
import com.example.superheroesapp.data.repository.SuperheroesRepositoryImpl
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return Gson()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                },
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideSuperHeroesDatabase(app: Application): SuperHeroesDatabase {
        return Room.databaseBuilder(
            app,
            SuperHeroesDatabase::class.java,
            "superheroesDatabase",
        ).build()
    }

    @Provides
    @Singleton
    fun provideMarvelApi(client: OkHttpClient, gson: Gson): MarvelApiService =
        Retrofit.Builder()
            .baseUrl(MarvelApiService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
            .create()
}

@Provides
@Singleton
fun provideSuperHeroesRepository(
    api: MarvelApiService,
    db: SuperHeroesDatabase): SuperheroesRepositoryImpl {
    return SuperheroesRepositoryImpl(api, db.dao)
}
