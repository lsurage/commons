package com.indorecommons.view

import android.opengl.Visibility
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.indorecommons.R
import com.indorecommons.view.adapters.GitRepoAdapter
import com.indorecommons.viewModel.ListViewModel
import kotlinx.android.synthetic.main.list_fragment.*

class ListFragment : Fragment() {

    companion object {
        fun newInstance() = ListFragment()
    }

    private lateinit var viewModel: ListViewModel

    private val repoAdapter = GitRepoAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        viewModel.refresh()
        repoList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = repoAdapter
        }
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.repos.observe(viewLifecycleOwner, Observer { repos ->
            repos?.let {
                repoList.visibility = View.VISIBLE
                repoAdapter.updateRepoList(repos)

            }
        })

        viewModel.loadError.observe(viewLifecycleOwner, Observer { error ->
            error?.let {
                listError.visibility = if (it) View.VISIBLE else View.GONE
            }
        })
        viewModel.loading.observe(viewLifecycleOwner, Observer { loading ->
            loading?.let {
                loadingView.visibility = if (it) View.VISIBLE else View.GONE
                if(it){
                    listError.visibility = View.GONE
                    repoList.visibility = View.GONE
                }

            }
        })

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }

}
