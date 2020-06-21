package com.indorecommons.network.api

import com.indorecommons.model.GitRepoDataModel
import io.reactivex.Single
import retrofit2.http.GET

interface GitRepoApi {
    @GET("repositories")
    fun getGitRepos(): Single<List<GitRepoDataModel>>
}