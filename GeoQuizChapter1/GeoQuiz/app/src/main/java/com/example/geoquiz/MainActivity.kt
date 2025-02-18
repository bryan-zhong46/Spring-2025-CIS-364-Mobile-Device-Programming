package com.example.geoquiz

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    // 2/11/25 declare two class data members for two buttons
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // binding the variable with the widget in the layout
        trueButton = findViewById(R.id.true_button) // R.id lists all the ids
        falseButton = findViewById(R.id.false_button)

        // listener for process user's click event
        trueButton.setOnClickListener { view: View ->
            // Toast
            /*Toast.makeText( this,
                R.string.correct_toast,
                Toast.LENGTH_SHORT).show()*/

            // Step 1: Snackbar to check user's answer
            Snackbar.make(view, R.string.correct_toast, Snackbar.LENGTH_SHORT).show()
            
            // Step 2: Snackbar to give user chance to undo answer
            val mySnackbar = Snackbar.make(view, R.string.ask_if_sure, Snackbar.LENGTH_SHORT)        
            mySnackbar.setAction("UNDO", UndoListener())
            mySnackbar.show()
        }

        falseButton.setOnClickListener { view: View ->
            // Toast
            /*Toast.makeText( this,
                R.string.incorrect_toast,
                Toast.LENGTH_SHORT).show()*/

            // Step 1: Snackbar to check user's answer
            Snackbar.make(view, R.string.incorrect_toast, Snackbar.LENGTH_SHORT).show()
            
            // Step 2: Snackbar to give user chance to undo answer
            val mySnackbar = Snackbar.make(view, R.string.ask_if_sure, Snackbar.LENGTH_SHORT)        
            mySnackbar.setAction("UNDO", UndoListener())
            mySnackbar.show()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}