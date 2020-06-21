package com.indorecommons.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.indorecommons.model.GitRepoData

@Dao
interface GitRepoDao {

    @Insert
    suspend fun insertAll(vararg gitRepoData: GitRepoData): List<Long>

    @Query("SELECT * FROM gitrepodata")
    suspend fun getAllRepo(): List<GitRepoData>

    @Query("SELECT * FROM gitrepodata WHERE id = :id ")
    suspend fun getGitRepo(id: Int): GitRepoData

    @Query("DELETE FROM gitrepodata")
    suspend fun deleteAllRepo()

}