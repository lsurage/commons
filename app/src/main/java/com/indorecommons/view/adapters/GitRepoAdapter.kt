package com.indorecommons.view.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.indorecommons.model.GitRepoDataModel

class GitRepoAdapter(val repoList:ArrayList<GitRepoDataModel>): RecyclerView.Adapter<GitRepoAdapter.GitRepoHolder>() {

    class GitRepoHolder(var view: View): RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitRepoHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: GitRepoHolder, position: Int) {
        TODO("Not yet implemented")
    }
}