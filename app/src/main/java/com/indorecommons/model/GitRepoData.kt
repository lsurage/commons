package com.indorecommons.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class GitRepoData(
    @ColumnInfo(name ="id")
    @PrimaryKey
    @SerializedName("id")
    val id: Int?,
    @ColumnInfo(name ="name")
    @SerializedName("name")
    val name: String?,


    @ColumnInfo(name ="full_name")
    @SerializedName("full_name")
    val fullName: String?,


    @Embedded
    @SerializedName("owner")
    val owner: Owner?
)


data class Owner(
    @ColumnInfo(name ="login")
    @SerializedName("login")
    val login: String?,

    @ColumnInfo(name ="node_id")
    @SerializedName("node_id")
    val nodeId: String?,

    @ColumnInfo(name ="avatar_url")
    @SerializedName("avatar_url")
    val avatarUrl: String?,

    @ColumnInfo(name ="type")
    @SerializedName("type")
    val type: String?,

    @ColumnInfo(name ="url")
    @SerializedName("url")
    val url: String?,

    @ColumnInfo(name ="html_url")
    @SerializedName("html_url")
    val htmlUrl: String?
)