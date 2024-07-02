//student number: 301340005
package com.example.samanthaschlegel_comp304_001_hands_on_test1_s24// MainActivity.kt (com.example.samanthaschelgel_comp304_001_hands_on_test1_s24.SamanthaActivity.kt)
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.samanthaschlegel_comp304_001_hands_on_test1_s24.R

class SamanthaActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_samantha)

        val btnNext = findViewById<ImageButton>(R.id.Button1)
        btnNext.setOnClickListener {
            val intent = Intent(this, SchlegelActivity::class.java)
            startActivity(intent)
        }
    }
}
