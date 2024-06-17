package com.naufalm.haditsar.data

import com.naufalm.haditsar.data.models.Hadits
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("v1/api/hadits")
    suspend fun getPosts(): List<Hadits>

    companion object {
        private var apiService: ApiService? = null
        fun getInstance(): ApiService {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl("https://ar-aplication.vercel.app/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiService::class.java)
            }
            return apiService!!
        }
    }
}