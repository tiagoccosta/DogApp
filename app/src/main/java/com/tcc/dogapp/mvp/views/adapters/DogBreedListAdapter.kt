package com.tcc.dogapp.mvp.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tcc.dogapp.R
import com.tcc.dogapp.mvp.models.Dog
import java.util.*


class IssueListAdapter(private val issueList: List<Dog>) : RecyclerView.Adapter<IssueListAdapter.ViewHolder>() {
    override fun getItemCount(): Int {
        return issueList.size
    }

    private var issueClickListener: IssueClickListener? = null


    init {
        Collections.sort<Dog>(
            this.issueList
        ) { lhs, rhs -> lhs.hashCode() - rhs.hashCode() }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.list_item, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        val issue = issueList[i]
        viewHolder.issueTitle.text = issue.name
        viewHolder.rootView.setOnClickListener {
            if (issueClickListener != null) {
                issueClickListener!!.onIssueClicked(issue)
            }
        }
    }

    fun setIssueClickListener(issueClickListener: IssueClickListener) {
        this.issueClickListener = issueClickListener
    }

    class ViewHolder(internal var rootView: View) : RecyclerView.ViewHolder(rootView) {
        internal var issueTitle: TextView = rootView.findViewById(R.id.dog_title)
    }

    interface IssueClickListener {

        fun onIssueClicked(dog: Dog)
    }
}