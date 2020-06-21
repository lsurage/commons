package com.indorecommons.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.indorecommons.R
import com.indorecommons.databinding.ItemGitRepoBinding
import com.indorecommons.listner.OnItemClickListner
import com.indorecommons.model.GitRepoData
import com.indorecommons.utils.getProgressDrawable
import com.indorecommons.utils.loadImage
import com.indorecommons.view.ListFragmentDirections
import kotlinx.android.synthetic.main.item_git_repo.view.*

class GitRepoAdapter(val repoList: ArrayList<GitRepoData>) :
    RecyclerView.Adapter<GitRepoAdapter.GitRepoHolder>(), OnItemClickListner {

    class GitRepoHolder(var view: ItemGitRepoBinding) : RecyclerView.ViewHolder(view.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitRepoHolder {
        val inflater = LayoutInflater.from(parent.context)
//        val view = inflater.inflate(R.layout.item_git_repo, parent, false)
        val view = DataBindingUtil.inflate<ItemGitRepoBinding>(
            inflater,
            R.layout.item_git_repo,
            parent,
            false
        )
        return GitRepoHolder(view)
    }

    override fun getItemCount() = repoList.size

    override fun onBindViewHolder(holder: GitRepoHolder, position: Int) {
        holder.view.repo = repoList[position]
        holder.view.listener = this
    }


    fun updateRepoList(newList: ArrayList<GitRepoData>) {
        repoList.clear()
        repoList.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onClick(v: View) {
        val id = v.userId.text.toString().toInt()
        val action = ListFragmentDirections.actionToDetails()
        action.userId = id
        Navigation.findNavController(v).navigate(action)
    }
}