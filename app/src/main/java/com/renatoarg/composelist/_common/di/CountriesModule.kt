package com.renatoarg.composelist._common.di

import com.renatoarg.composelist.BuildConfig
import com.renatoarg.composelist.model.ApiService
import com.renatoarg.composelist.model.ApiServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.serialization.json.Json
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Singleton
    @Provides
    fun provideHttpClient():HttpClient{
        val httpClient = HttpClient(Android){
            install(Logging){
                level=LogLevel.ALL
            }
            install(DefaultRequest){
                url(Util.BASE_URL)
                header(HttpHeaders.ContentType, "application/vnd.api+json")
            }
            install(ContentNegotiation){
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
        }

        return httpClient
    }

    @Singleton
    @Provides
    fun provideApiService(httpClient: HttpClient): ApiService = ApiServiceImpl(httpClient)

    @Provides
    fun provideDispatcher(): CoroutineDispatcher = Dispatchers.Default

    object Util {
        const val BASE_URL="https://restcountries.com/v3.1/"
    }
}