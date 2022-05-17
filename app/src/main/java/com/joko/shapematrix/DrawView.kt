package com.joko.shapematrix

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import androidx.core.graphics.values
import com.github.chrisbanes.photoview.PhotoView

class DrawView(private val ctx: Context, private val attributeSet: AttributeSet): PhotoView(ctx, attributeSet) {

    val TAG = "DrawView"

    private val circles = listOf(Circle(1, 200f, 200f))

    init {
        attacher.setOnMatrixChangeListener {

        }
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)

        val matrix = attacher.imageMatrix
        val displayReact = attacher.displayRect
        val viewReact = RectF(0f, 0f, width.toFloat(), height.toFloat())

        canvas.save()

        circles.forEach {
            Log.d(TAG, "draw: screen width ${width}")
            Log.d(TAG, "draw: image width ${displayReact.width()}")
            Log.d(TAG, "draw: trans x ${matrix.values()[Matrix.MTRANS_X]}")
            Log.d(TAG, "draw: screen height ${height}")
            Log.d(TAG, "draw: image height ${displayReact.height()}")
            Log.d(TAG, "draw: trans y ${matrix.values()[Matrix.MTRANS_Y]}")

            val xResult =  (it.x * displayReact.width()) / width.toFloat() * matrix.values()[Matrix.MSCALE_X] + (matrix.values()[Matrix.MTRANS_X])
            val yResult =  (it.y * displayReact.height()) / height.toFloat() * matrix.values()[Matrix.MSCALE_Y] + (matrix.values()[Matrix.MTRANS_Y])

            Log.d(TAG, "draw: x = ${it.x} | X RESULT = ${xResult}")
            Log.d(TAG, "draw: y = ${it.y} | Y RESULT = ${yResult}")
            Log.d(TAG, "")
            // Log.d(TAG, "draw: trans y ${matrix.values()[Matrix.MTRANS_Y]}")

            val x: Int = (width - displayReact.width().toInt()) / 2
            val y: Int = (height - displayReact.height().toInt()) / 2

            val dx = x * it.x
            val dy = y * it.y

            // Log.d(TAG, "draw: before ${dx}")
            // Log.d(TAG, "draw: after ${dy}")

            // Log.d(TAG, "draw: $matrix")

            canvas.drawCircle(xResult, yResult, 20f, Paint().apply {
                color = Color.MAGENTA
            })
        }

        canvas.restore()

    }


}