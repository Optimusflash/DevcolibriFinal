package com.optimus.devcolibrifinal.remote

import com.optimus.devcolibrifinal.model.Book
import io.reactivex.Single
import retrofit2.http.GET

/**
 * Created by Dmitriy Chebotar on 19.04.2020.
 */
interface BookRemoteService {
    @GET("0f14812045073a3052d4")
    fun loadBooks():Single<List<Book>>
}