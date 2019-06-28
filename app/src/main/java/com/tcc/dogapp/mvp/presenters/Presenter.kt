package com.tcc.dogapp.mvp.presenters


import android.util.Log
import com.tcc.dogapp.mvp.models.Dog
import com.tcc.dogapp.mvp.models.DogImage
import com.tcc.dogapp.mvp.models.network.interfaces.DogApiInterface
import com.tcc.dogapp.mvp.views.interfaces.ActivityBaseInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class Presenter(private val dogApiInterface: DogApiInterface) : PresenterInterface {


    override fun requestDogList(activity: ActivityBaseInterface ) {

        //this.activity = activity
        val call = dogApiInterface.getDogs()

        call.enqueue(object : Callback<ArrayList<Dog>> {
            override fun onFailure(call: Call<ArrayList<Dog>>?, t: Throwable?) {
                //
                Log.i("ERROR", (t!!.message))
            }

            override fun onResponse(call: Call<ArrayList<Dog>>?, response: Response<ArrayList<Dog>>?) {
                //
                if (response!!.isSuccessful) {
                    response.body()?.let { activity.showDogList(it) }

                } else {
                    Log.i("ERROR", (response.code().toString()))
                }
            }
        })

    }


    override fun requestDogImage(activity: ActivityBaseInterface, dog: Dog) {

        //this.activity = activity
        val call = dogApiInterface.getRandomDogImage(dog.id)

        call.enqueue(object : Callback<ArrayList<DogImage>> {
            override fun onFailure(call: Call<ArrayList<DogImage>>?, t: Throwable?) {
                //
                Log.i("ERROR", (t!!.message))
            }

            override fun onResponse(call: Call<ArrayList<DogImage>>?, response: Response<ArrayList<DogImage>>?) {
                //
                if (response!!.isSuccessful) {
                    response.body()?.let { activity.dogImageReceived(dog,it[0]) }

                } else {
                    Log.i("ERROR", (response.code().toString()))
                }
            }
        })

    }

    override fun onDogSelected(activity: ActivityBaseInterface, dog: Dog) {
        activity.showDogDetails(dog)
    }


}
