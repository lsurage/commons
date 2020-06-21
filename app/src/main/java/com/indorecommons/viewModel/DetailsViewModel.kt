package com.indorecommons.viewModel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.indorecommons.model.GitRepoDataModel
import com.indorecommons.model.Owner

class DetailsViewModel(application: Application) : BaseViewModel(application) {

    val repo = MutableLiveData<GitRepoDataModel>()

    fun fetch() {
        repo.value = GitRepoDataModel(
            1, "lokesh", "lokesh surage", Owner(
                "lomdo", "sdaljsdflajsd", "admin", "www.goog.co", "sdfasd", "asdfasd"
            )
        )
    }
}
