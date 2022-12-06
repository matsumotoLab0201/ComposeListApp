package com.example.jetpackcomposemvvmretrofitandrecyclerview

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET("sample.json")
    suspend fun getMovies() : List<Movie>

    companion object {
        var apiService: ApiService? = null
        fun getInstance() : ApiService {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl(
                        "https://raw.githubusercontent.com/matumotokohei/testJson/master/json/"
                     )
                    .addConverterFactory(GsonConverterFactory.create())
                .build().create(ApiService::class.java)
            }
            return apiService!!
        }
    }

    //BASE  URL
    //https://howtodoandroid.com/apis/   movielist.json
    //https://raw.githubusercontent.com/matumotokohei/testApi/main/sample.json

}