package com.indorecommons.model

data class GitRepoDataModel(
    val id: Int?,
    val name: String?,
    val fullName: String?,
    val owner: Owner?
)


data class Owner(
    val login: String?,
    val nodeId: String?,
    val avatarUrl: String?,
    val type: String?,
    val url: String?,
    val htmlUrl: String?
)