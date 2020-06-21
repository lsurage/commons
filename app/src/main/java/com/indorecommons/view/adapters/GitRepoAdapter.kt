package com.indorecommons.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.indorecommons.R
import com.indorecommons.model.GitRepoData
import com.indorecommons.utils.getProgressDrawable
import com.indorecommons.utils.loadImage
import com.indorecommons.view.ListFragmentDirections
import kotlinx.android.synthetic.main.item_git_repo.view.*

class GitRepoAdapter(val repoList: ArrayList<GitRepoData>) :
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

        holder.view.avatar.loadImage(
            repoList[position].owner?.avatarUrl,
            getProgressDrawable(holder.view.avatar.context)
        )
        holder.view.setOnClickListener { view ->
            val action = ListFragmentDirections.actionToDetails()
            action.userId = repoList[position].id!!
            Navigation.findNavController(view).navigate(action)
        }
    }


    fun updateRepoList(newList: ArrayList<GitRepoData>) {
        repoList.clear()
        repoList.addAll(newList)
        notifyDataSetChanged()
    }
}