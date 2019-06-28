package com.tcc.dogapp.mvp.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


open class DogImage() : Parcelable {


    @SerializedName("id")
    var id: String? = null
        internal set

    @SerializedName("height")
    var height: Int = 0
        internal set

    @SerializedName("width")
    var width: Int = 0
        internal set

    @SerializedName("url")
    var url: String? = null
        internal set


    constructor(parcel: Parcel) : this() {
        this.id = parcel.readString()
        this.height = parcel.readInt()
        this.width = parcel.readInt()
        this.url = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

        parcel.writeString(this.id)
        parcel.writeInt(this.height)
        parcel.writeInt(this.width)
        parcel.writeString(this.url)

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DogImage> {
        override fun createFromParcel(parcel: Parcel): DogImage {
            return DogImage(parcel)
        }

        override fun newArray(size: Int): Array<DogImage?> {
            return arrayOfNulls(size)
        }
    }

}



/*
height:194
id:BJE_kx5VQ
url:https://cdn2.thedogapi.com/images/BJE_kx5VQ_1280.jpg
width:260
 */