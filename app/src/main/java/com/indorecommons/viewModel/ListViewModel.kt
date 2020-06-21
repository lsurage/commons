package com.indorecommons.viewModel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.indorecommons.database.GitRepoDatabase
import com.indorecommons.model.GitRepoData
import com.indorecommons.network.RetroFitService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch

class ListViewModel(application: Application) : BaseViewModel(application) {
    val repos = MutableLiveData<ArrayList<GitRepoData>>()
    val loadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()


    private val gitRepoService = RetroFitService()
    private val disposable = CompositeDisposable()


    fun refresh() {
        fetchFromRemote()
    }


    private fun fetchFromRemote() {

        loading.value = true
        disposable.add(
            gitRepoService.getRepositories()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<GitRepoData>>() {
                    override fun onSuccess(t: List<GitRepoData>) {
                        storeReposLocally(t)
                    }

                    override fun onError(e: Throwable) {
                        loadError.value = true
                        loading.value = false
                    }

                })
        )


    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }


    private fun gitRepoFetched(repoList: List<GitRepoData>) {
        repos.value = repoList as ArrayList<GitRepoData>
        loadError.value = false
        loading.value = false
    }

    private fun storeReposLocally(repoList: List<GitRepoData>) {
        launch {
            val gitDao = GitRepoDatabase(getApplication()).gitRepoDao()
            gitDao.deleteAllRepo()
            gitDao.insertAll(*repoList.toTypedArray())
            gitRepoFetched(repoList)
        }
    }
}
