package com.tcc.dogapp.mvp.views.interfaces

import com.tcc.dogapp.mvp.models.Dog
import com.tcc.dogapp.mvp.models.DogImage
import com.tcc.dogapp.mvp.presenters.PresenterInterface

interface ActivityBaseInterface {

    fun setPresenterInterface(listener: PresenterInterface)


    fun showDogList(dog: List<Dog>)

    fun showDogDetails(dog: Dog)

    fun dogImageReceived(dog: Dog, image: DogImage)

}