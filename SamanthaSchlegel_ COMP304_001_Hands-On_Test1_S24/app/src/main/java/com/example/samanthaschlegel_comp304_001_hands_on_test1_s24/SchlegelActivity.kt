//student number: 301340005
package com.example.samanthaschlegel_comp304_001_hands_on_test1_s24
import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SchlegelActivity : AppCompatActivity() {

    private lateinit var radioGroup: RadioGroup
    private lateinit var btnNext: Button
    private lateinit var imageZigzag: ImageView


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schlegel)

        radioGroup = findViewById(R.id.radioGroup1)
        btnNext = findViewById(R.id.Nextbutton)
        imageZigzag = findViewById(R.id.imageView3)

        btnNext.setOnClickListener {
            val selectedExercise = when (radioGroup.checkedRadioButtonId) {
                R.id.Lose -> "Loose things"
                R.id.remember -> "Remember names"
                R.id.learn -> "Learn things quickly"
                R.id.keep -> "Keep track of Multiple things"
                else -> "No Exercise Selected"
            }

            showToast(selectedExercise)
        }

        drawZigzagLine()
    }

    private fun showToast(exercise: String) {
        Toast.makeText(this, "Selected Exercise: $exercise", Toast.LENGTH_SHORT).show()
    }

    private fun drawZigzagLine() {
        val yCoordinates = resources.getStringArray(R.array.y_coordinates)

        val bitmap = Bitmap.createBitmap(900, 300, Bitmap.Config.ARGB_8888) // Adjust bitmap width and height as needed
        val canvas = Canvas(bitmap)
        val paint = Paint()
        paint.color = Color.RED
        paint.strokeWidth = 5f

        var startX = 0f
        var startY = 0f
        val increment = 100

        for (i in yCoordinates.indices) {
            val endX = startX + increment
            val endY = yCoordinates[i].toFloat()
            canvas.drawLine(startX, startY, endX, endY, paint)
            startX = endX
            startY = endY
        }

        imageZigzag.setImageBitmap(bitmap)
    }

}
