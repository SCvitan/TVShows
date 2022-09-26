package com.example.droid1.api

import com.example.droid1.helper.Constants.END_POINT
import com.example.droid1.model.Movies
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(END_POINT)
    suspend fun getTvShows():Response<Movies>

}