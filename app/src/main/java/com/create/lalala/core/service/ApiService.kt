package com.create.lalala.core.service
import com.create.lalala.data.model.PartAPI
import retrofit2.Response
import retrofit2.http.GET
interface ApiService {
    @GET("api/app/ST261_CatMakerKittyLab")
    suspend fun getAllData(): Response<Map<String, List<PartAPI>>>
}