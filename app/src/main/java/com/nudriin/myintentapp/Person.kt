package com.nudriin.myintentapp

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//membuat data class yang implements Parcelable
/*
* Parcelable adalah suatu interface yang memungkinkan kita
* melakukan pengiriman satu objek sekaligus dari
* suatu Activity ke Activity lain.
* */

// KITA BISA MEMBUATNYA MENJADI PARCEABLE HANYA DENGAN MENGGUNAKAN @Parcelize
// NAMUN SEBELUM ITU TAMBHKAN DULU PLUGIN id("kotlin-parcelize") pada file build.gradle.kts (module: app)
@Parcelize
data class Person (
    val name: String?,
    val age: Int?,
    val email: String?,
    val city: String?
) : Parcelable {

//    KODE DI BAWAH INI ADALAH JIKA KITA TIDAK MENGGUNAKAN ANOTATION @parcelize
//    constructor(parcel: Parcel) : this(
//        parcel.readString(),
//        parcel.readValue(Int::class.java.classLoader) as? Int,
//        parcel.readString(),
//        parcel.readString()
//    ) {
//    }
//
//    override fun writeToParcel(parcel: Parcel, flags: Int) {
//        parcel.writeString(name)
//        parcel.writeValue(age)
//        parcel.writeString(email)
//        parcel.writeString(city)
//    }
//
//    override fun describeContents(): Int {
//        return 0
//    }
//
//    companion object CREATOR : Parcelable.Creator<Person> {
//        override fun createFromParcel(parcel: Parcel): Person {
//            return Person(parcel)
//        }
//
//        override fun newArray(size: Int): Array<Person?> {
//            return arrayOfNulls(size)
//        }
//    }
}