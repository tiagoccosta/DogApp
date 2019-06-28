package com.tcc.dogapp.mvp.models


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


open class Dog() : Parcelable {

    @SerializedName("name")
    var name: String = ""
        internal set

    @SerializedName("id")
    var id: String = ""
        internal set

    @SerializedName("bred_for")
    var createdFor: String? = null
        internal set

    @SerializedName("height")
    var height: Measure? = null
        internal set

    @SerializedName("weight")
    var weight: Measure? = null
        internal set

    @SerializedName("url")
    var temperament: String = ""
        internal set

    @SerializedName("origin")
    var origin: String = ""
        internal set

    constructor(parcel: Parcel) : this() {
        this.name = parcel.readString()
        this.id = parcel.readString()
        this.createdFor = parcel.readString()
        this.height = Measure()
        this.height!!.metric = parcel.readString()
        this.weight = Measure()
        this.weight!!.metric = parcel.readString()
        this.temperament = parcel.readString()
        this.origin = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

        parcel.writeString(this.name)
        parcel.writeString(this.id)
        parcel.writeString(this.createdFor)
        parcel.writeString(this.height!!.metric)
        parcel.writeString(this.weight!!.metric)
        parcel.writeString(this.temperament)
        parcel.writeString(this.origin)

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Dog> {
        override fun createFromParcel(parcel: Parcel): Dog {
            return Dog(parcel)
        }

        override fun newArray(size: Int): Array<Dog?> {
            return arrayOfNulls(size)
        }
    }

}


class Measure {
    @SerializedName("metric")
    var metric: String? = null
        internal set

}