package com.optimus.devcolibrifinal.adapters

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.RectF
import android.util.Log
import android.view.MotionEvent
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.optimus.devcolibrifinal.R
import com.optimus.devcolibrifinal.extensions.dpToPx
import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator

/**
 * Created by Dmitriy Chebotar on 21.04.2020.
 */
class ItemTouchCallback(val adapter: BookAdapter) : ItemTouchHelper.Callback() {


    private val bgRect = RectF()
    private val iconBounds = Rect()
    private val bgPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        return makeFlag(ItemTouchHelper.ACTION_STATE_SWIPE, ItemTouchHelper.START)
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return false
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

    }

    override fun onChildDraw(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {

        if (dX < 0) {
            val itemView = viewHolder.itemView
            val iconSize = itemView.context.dpToPx(56)
            val space = itemView.context.dpToPx(16)
            val translationX = dX *(iconSize+space*2)/itemView.width
            if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
                drawIcon(c, itemView, translationX)
            }

            Log.e("M_ItemTouchCallback", "$dX")
            super.onChildDraw(c, recyclerView, viewHolder, translationX, dY, actionState, isCurrentlyActive)
        }
    }

    private fun drawIcon(canvas: Canvas, itemView: View, dX: Float) {
        val icon =
            itemView.resources.getDrawable(R.drawable.ic_android_black_24dp, itemView.context.theme)

        val iconSize = itemView.context.dpToPx(56)
        val space = itemView.context.dpToPx(16)

        val margin = (itemView.bottom - itemView.top - iconSize) / 2
        with(iconBounds) {
            left = itemView.right + dX.toInt() + space.toInt()
            top = itemView.top + margin.toInt()
            right = itemView.right + dX.toInt() + iconSize.toInt() + space.toInt()
            bottom = itemView.bottom - margin.toInt()

        }

        icon.bounds = iconBounds
        icon.draw(canvas)
    }

}