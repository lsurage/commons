package com.indorecommons.network.api

import com.indorecommons.model.GitRepoData
import io.reactivex.Single
import retrofit2.http.GET

interface GitRepoApi {
    @GET("repositories")
    fun getGitRepos(): Single<List<GitRepoData>>
}