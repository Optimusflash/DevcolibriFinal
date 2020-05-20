package com.optimus.devcolibrifinal.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by Dmitriy Chebotar on 19.04.2020.
 */
@Entity(tableName = "Book")
data class Book(
    @PrimaryKey
    @SerializedName("id") val id : Int,
    @SerializedName("title") val title : String,
    @SerializedName("image_url") val imageUrl : String,
    @SerializedName("description") val description : String
) {
}