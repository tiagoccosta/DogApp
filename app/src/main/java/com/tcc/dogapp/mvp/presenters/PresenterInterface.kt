package com.tcc.dogapp.mvp.presenters

import com.tcc.dogapp.mvp.models.Dog
import com.tcc.dogapp.mvp.views.interfaces.ActivityBaseInterface

interface PresenterInterface {


    fun onDogSelected(
        activity: ActivityBaseInterface,
        dog: Dog
    )

    fun requestDogList(activity: ActivityBaseInterface)

    fun requestDogImage(activity: ActivityBaseInterface, dog: Dog)

}
