package com.indorecommons.network

import com.indorecommons.model.GitRepoData
import com.indorecommons.network.api.GitRepoApi
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetroFitService {

    private val BASE_URL = "https://api.github.com"

    private val api =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(GitRepoApi::class.java)


    fun getRepositories(): Single<List<GitRepoData>> {
        return api.getGitRepos()
    }
}