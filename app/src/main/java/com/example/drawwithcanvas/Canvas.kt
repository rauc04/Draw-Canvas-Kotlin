package com.example.drawwithcanvas

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View

class Canvas(context: Context) : View(context) {
    lateinit var paint: Paint
    var xPositionOne: Float = 0f
    var yPositionOne: Float = 0f
    var xPositionTwo: Float = 0f
    var yPositionTwo: Float = 0f
    var point: Int = 0

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint = Paint()
        paint.color = Color.LTGRAY
        paint.strokeWidth = 10f
        paint.style = Paint.Style.STROKE

        if (point == 2) {
            canvas?.drawLine(xPositionOne, yPositionOne, xPositionTwo, yPositionTwo, paint)
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (point == 1) {
            xPositionOne = event.x
            yPositionOne = event.y
            point = 2
        } else {
            xPositionTwo = event.x
            yPositionTwo = event.y
            point = 1
        }
        invalidate()
        return super.onTouchEvent(event)
    }
}