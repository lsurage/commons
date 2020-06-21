package com.indorecommons.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.indorecommons.model.GitRepoData

@Database(entities = arrayOf(GitRepoData::class),version = 1)
abstract class GitRepoDatabase :RoomDatabase(){

    abstract fun gitRepoDao(): GitRepoDao

    companion object {
        @Volatile private var instance: GitRepoDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            GitRepoDatabase::class.java,
            "gitrepodatabase"
        ).build()
    }
}