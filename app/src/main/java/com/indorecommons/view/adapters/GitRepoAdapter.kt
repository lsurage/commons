package com.indorecommons.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.indorecommons.R
import com.indorecommons.model.GitRepoDataModel
import kotlinx.android.synthetic.main.details_fragment.view.*

class GitRepoAdapter(val repoList: ArrayList<GitRepoDataModel>) :
    RecyclerView.Adapter<GitRepoAdapter.GitRepoHolder>() {

    class GitRepoHolder(var view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitRepoHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_git_repo, parent, false)
        return GitRepoHolder(view)
    }

    override fun getItemCount() = repoList.size

    override fun onBindViewHolder(holder: GitRepoHolder, position: Int) {
        holder.view.userFullName.text = repoList[position].fullName
        holder.view.userType.text = repoList[position].owner?.type
        holder.view.nodeId.text = repoList[position].owner?.nodeId
        holder.view.url.text = repoList[position].owner?.url
    }


    fun updateRepoList(newList: ArrayList<GitRepoDataModel>) {
        repoList.clear()
        repoList.addAll(newList)
        notifyDataSetChanged()
    }
}