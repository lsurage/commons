package com.indorecommons.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.indorecommons.R
import com.indorecommons.model.GitRepoDataModel
import com.indorecommons.view.ListFragmentDirections
import kotlinx.android.synthetic.main.details_fragment.view.*
import kotlinx.android.synthetic.main.item_git_repo.view.*

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
        holder.view.fullName.text = repoList[position].fullName
        holder.view.name.text = repoList[position].name
        holder.view.userId.text = repoList[position].id.toString()
        holder.view.setOnClickListener { view ->
            val action = ListFragmentDirections.actionToDetails()
            action.userId = repoList[position].id!!
            Navigation.findNavController(view).navigate(action)
        }
    }


    fun updateRepoList(newList: ArrayList<GitRepoDataModel>) {
        repoList.clear()
        repoList.addAll(newList)
        notifyDataSetChanged()
    }
}