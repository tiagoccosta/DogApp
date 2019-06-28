package com.tcc.dogapp.mvp.views.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tcc.dogapp.App
import com.tcc.dogapp.R
import com.tcc.dogapp.mvp.models.Dog
import com.tcc.dogapp.mvp.models.DogImage
import com.tcc.dogapp.mvp.presenters.PresenterInterface
import com.tcc.dogapp.mvp.views.adapters.DogBreedListAdapter
import com.tcc.dogapp.mvp.views.interfaces.ActivityBaseInterface

class MainActivity : AppCompatActivity(), ActivityBaseInterface, DogBreedListAdapter.DogClickListener {

    private var issueListRecycler: RecyclerView? = null


    private var anInterface: PresenterInterface? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as App).appComponent!!.inject(this)

        issueListRecycler = findViewById(R.id.recycler_dog_breed_list)
        issueListRecycler!!.setHasFixedSize(true)
        issueListRecycler!!.layoutManager = LinearLayoutManager(this)

        App.instance!!.presenter?.let { setPresenterInterface(it) }


    }


    override fun setPresenterInterface(anInterface: PresenterInterface) {
        this.anInterface = anInterface
        this.anInterface!!.requestDogList(this)
    }





    override fun showDogList(dog: List<Dog>) {
        val issuesAdapter = DogBreedListAdapter(dog)
        issuesAdapter.setDogClickListener (this)
        issueListRecycler!!.adapter = issuesAdapter
    }

    override fun onDogClicked(dog: Dog) {
        anInterface!!.onDogSelected(this, dog)
    }

    override fun showDogDetails(dog: Dog) {
        val intent = Intent(this, DogActivity::class.java)
        intent.putExtra(DogActivity.EXTRA_ISSUE, dog)
        startActivity(intent)
    }

    override fun dogImageReceived(dog: Dog, image: DogImage) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
