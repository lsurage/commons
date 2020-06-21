package com.indorecommons.viewModel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.indorecommons.model.GitRepoData
import com.indorecommons.model.Owner

class DetailsViewModel(application: Application) : BaseViewModel(application) {

    val repo = MutableLiveData<GitRepoData>()

    fun fetch() {
        repo.value = GitRepoData(
            1, "lokesh", "lokesh surage", Owner(
                "lomdo", "sdaljsdflajsd", "admin", "www.goog.co", "sdfasd", "asdfasd"
            )
        )
    }
}
