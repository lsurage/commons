package com.indorecommons.viewModel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.indorecommons.database.GitRepoDatabase
import com.indorecommons.model.GitRepoData
import com.indorecommons.model.Owner
import kotlinx.coroutines.launch

class DetailsViewModel(application: Application) : BaseViewModel(application) {

    val repo = MutableLiveData<GitRepoData>()

    fun fetch(id: Int) {
        launch {
            val gitRepo = GitRepoDatabase(getApplication()).gitRepoDao().getGitRepo(id)

            repo.value = gitRepo
        }

    }
}
