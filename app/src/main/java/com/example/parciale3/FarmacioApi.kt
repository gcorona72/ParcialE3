import com.example.parciale3.Farmacia

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface FarmaciaApi {
    @GET("farmacias_Equipamiento")
    suspend fun getFarmacias(): List<Farmacia>
}

object RetrofitHelper {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://www.zaragoza.es/georref/json/hilo/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: FarmaciaApi = retrofit.create(FarmaciaApi::class.java)
}
