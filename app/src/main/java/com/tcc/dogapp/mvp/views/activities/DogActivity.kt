package com.tcc.dogapp.mvp.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.tcc.dogapp.App
import com.tcc.dogapp.R
import com.tcc.dogapp.mvp.models.Dog
import com.tcc.dogapp.mvp.models.DogImage
import com.tcc.dogapp.mvp.presenters.PresenterInterface
import com.tcc.dogapp.mvp.views.interfaces.ActivityBaseInterface

class DogActivity :  AppCompatActivity(), ActivityBaseInterface {

    private lateinit var listener: PresenterInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog)
        App.instance!!.presenter?.let { setPresenterInterface(it) }

        val issue = intent.getParcelableExtra(EXTRA_ISSUE) as Dog
        listener.onDogSelected(this, issue)

    }

    override fun showDogDetails(dog: Dog) {
        listener.requestDogImage(this,dog)
        (findViewById<TextView>(R.id.breed_title)).text = dog.name
        (findViewById<TextView>(R.id.breed_created_for)).text = dog.createdFor
        (findViewById<TextView>(R.id.breed_temperament)).text = dog.temperament
        (findViewById<Button>(R.id.issue_url_btn)).setOnClickListener {
            listener.requestDogImage(this,dog)
        }

    }

    override fun setPresenterInterface(listener:PresenterInterface) {
        this.listener = listener
    }

    override fun showDogList(dog: List<Dog>) {
        onBackPressed()
    }


    override fun dogImageReceived(dog: Dog, image: DogImage) {
        Picasso.with(this@DogActivity).load(image!!.url).into(findViewById<ImageView>(R.id.breed_picture))
    }

    companion object {

        const val EXTRA_ISSUE = "extra_issue"
    }

}