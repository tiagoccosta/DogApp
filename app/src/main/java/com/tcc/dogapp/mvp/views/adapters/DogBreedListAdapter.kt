package com.tcc.dogapp.mvp.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tcc.dogapp.R
import com.tcc.dogapp.mvp.models.Dog
import java.util.*


class DogBreedListAdapter(private val dogList: List<Dog>) : RecyclerView.Adapter<DogBreedListAdapter.ViewHolder>() {
    override fun getItemCount(): Int {
        return dogList.size
    }

    private var dogClickListener: DogClickListener? = null


    init {
        Collections.sort<Dog>(
            this.dogList
        ) { lhs, rhs -> lhs.hashCode() - rhs.hashCode() }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.list_item, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        val issue = dogList[i]
        viewHolder.dogName.text = issue.name
        viewHolder.rootView.setOnClickListener {
            if (dogClickListener != null) {
                dogClickListener!!.onDogClicked(issue)
            }
        }
    }

    fun setDogClickListener(dogClickListener: DogClickListener) {
        this.dogClickListener = dogClickListener
    }

    class ViewHolder(internal var rootView: View) : RecyclerView.ViewHolder(rootView) {
        internal var dogName: TextView = rootView.findViewById(R.id.dog_title)
    }

    interface DogClickListener {

        fun onDogClicked(dog: Dog)
    }
}