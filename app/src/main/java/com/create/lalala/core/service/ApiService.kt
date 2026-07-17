package com.create.lalala.core.service
import com.create.lalala.data.model.PartAPI
import com.create.lalala.data.model.emoji.EmojiApiResponse
import retrofit2.Response
import retrofit2.http.GET
interface ApiService {
    @GET("api/app/ST295_HorrorEmojiMaker")
    suspend fun getAllData(): Response<Map<String, List<PartAPI>>>

    @GET("api/ST295_HorrorEmojiMaker/emoji")
    suspend fun getEmojiData(): Response<EmojiApiResponse>
}
