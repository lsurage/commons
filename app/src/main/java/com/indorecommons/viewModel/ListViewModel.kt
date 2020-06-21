package com.indorecommons.viewModel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.indorecommons.model.GitRepoDataModel
import com.indorecommons.model.Owner
import com.indorecommons.network.RetroFitService
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class ListViewModel(application: Application) : BaseViewModel(application) {
    val repos = MutableLiveData<ArrayList<GitRepoDataModel>>()
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
                .subscribeWith(object : DisposableSingleObserver<List<GitRepoDataModel>>() {
                    override fun onSuccess(t: List<GitRepoDataModel>) {
                        repos.value = t as ArrayList<GitRepoDataModel>
                        loadError.value = false
                        loading.value = false
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
}
