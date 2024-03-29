package com.example.superheroesapp.core.di

import android.app.Application
import androidx.room.Room
import com.example.superheroesapp.data.local.SuperHeroesDatabase
import com.example.superheroesapp.data.remote.service.MarvelApiService
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

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
    fun provideMarvelApi(client: OkHttpClient, gson: Gson): Retrofit =
        Retrofit.Builder()
            .baseUrl(MarvelApiService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
}
