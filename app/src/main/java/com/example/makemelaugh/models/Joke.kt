package com.example.makemelaugh.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Joke (

    @Expose
    @SerializedName("id")
    val id: String? = null,

    @Expose
    @SerializedName("type")
    val type: String? = null,

    @Expose
    @SerializedName("setup")
    val setup: String? = null,

    @Expose
    @SerializedName("punchline")
    val punchline: String? = null
){
    override fun toString(): String {
        return "User(id=$id,type=$type, setup=$setup, punchline=$punchline)"
    }
}