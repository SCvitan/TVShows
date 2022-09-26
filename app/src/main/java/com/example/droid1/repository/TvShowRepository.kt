package com.example.droid1.repository

import com.example.droid1.api.ApiService
import javax.inject.Inject

class TvShowRepository
@Inject
constructor(private val apiService: ApiService){

    suspend fun getTvShows() = apiService.getTvShows()
    

}