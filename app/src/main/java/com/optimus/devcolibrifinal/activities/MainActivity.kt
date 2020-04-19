package com.optimus.devcolibrifinal.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.optimus.devcolibrifinal.R
import com.optimus.devcolibrifinal.di.App
import com.optimus.devcolibrifinal.remote.BookRemoteService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var bookRemoteService: BookRemoteService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        App.component.inject(this)

        val disposable = bookRemoteService.loadBooks()  //TODO move to repository
            .subscribeOn(Schedulers.computation())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe({

            }, {

            })

    }
}
