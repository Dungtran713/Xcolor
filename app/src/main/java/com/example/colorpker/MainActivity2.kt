package com.example.colorpker
import android.graphics.Bitmap
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.*


class MainActivity2 : AppCompatActivity() {

      private lateinit var colorwheel: ImageView
      private lateinit var colorbar: View
      private lateinit var resultcolor: TextView
      private lateinit var bitmap: Bitmap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val actionBar = supportActionBar

        actionBar!!.title = " Color Wheel"

        actionBar.setDisplayHomeAsUpEnabled(true)



        colorwheel = findViewById(R.id.colorwheel)
        colorbar = findViewById(R.id.colorbar)
        resultcolor = findViewById(R.id.resultcolor)

        colorwheel.isDrawingCacheEnabled = true
        colorwheel.buildDrawingCache(true)


        colorwheel.isDrawingCacheEnabled = true
        colorwheel.buildDrawingCache(true)
        colorwheel.setOnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN || event.action == MotionEvent.ACTION_MOVE) {
                bitmap = colorwheel.getDrawingCache()
                val pixel = bitmap.getPixel(event.x.toInt(), event.y.toInt())
                val r = Color.red(pixel)
                val g = Color.green(pixel)
                val b = Color.blue(pixel)
                val hex = "#" + Integer.toHexString(pixel)
                colorbar.setBackgroundColor(Color.rgb(r, g, b))
                resultcolor.text = "RGB: $r, $g, $b \nHEX: $hex"
            }
            true
        }
    }
}