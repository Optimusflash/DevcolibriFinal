package com.optimus.devcolibrifinal.extensions

import android.content.Context

/**
 * Created by Dmitriy Chebotar on 21.04.2020.
 */

fun Context.dpToPx(dp: Int): Float {
    return dp.toFloat() * this.resources.displayMetrics.density
}

fun Context.pxToDp(px: Float): Float {
    return px / this.resources.displayMetrics.density
}