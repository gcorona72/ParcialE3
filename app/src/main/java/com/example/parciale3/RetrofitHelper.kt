package com.example.parciale3


import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

data class Farmacia(
    val title: String,
    val telefono: String?,
    val geometry: Geometry
)

data class Geometry(
    val coordinates: List<Double>
)

interface FarmaciaApi {
    @GET("farmacias_Equipamiento")
    suspend fun getFarmacias(): List<Farmacia>
}

object RetrofitHelper {
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY // Esto nos permite ver el cuerpo de la respuesta
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://www.zaragoza.es/georref/json/hilo/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    val api: FarmaciaApi = retrofit.create(FarmaciaApi::class.java)
}
