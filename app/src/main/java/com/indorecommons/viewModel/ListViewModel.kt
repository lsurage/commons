package com.indorecommons.viewModel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.indorecommons.model.GitRepoDataModel
import com.indorecommons.model.Owner

class ListViewModel(application: Application) : BaseViewModel(application) {
    val repos = MutableLiveData<ArrayList<GitRepoDataModel>>()
    val loadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()


    fun refresh() {
        var repo1 = GitRepoDataModel(
            1, "lokesh", "lokesh surage", Owner(
                "lomdo", "sdaljsdflajsd", "admin", "www.goog.co", "sdfasd", "asdfasd"
            )
        )
        var repo2 = GitRepoDataModel(
            1, "lokesh", "lokesh surage", Owner(
                "lomdo", "sdaljsdflajsd", "admin", "www.goog.co", "sdfasd", "asdfasd"
            )
        )
        val repolist = arrayListOf<GitRepoDataModel>(repo1, repo2, repo1)
        repos.value = repolist

        loadError.value = false
        loading.value = false

    }
}
