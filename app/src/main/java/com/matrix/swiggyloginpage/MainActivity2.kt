package com.matrix.swiggyloginpage

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    // Declaration of variables
    private var etname: EditText? = null
    private lateinit var confirmbutton: Button // Late initialization
    private var btnMove: Button? = null
    private val TAG = "MainActivity2"
    private var previousName = ""
    private var previousNumber = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        etname = findViewById(R.id.name)
        confirmbutton = findViewById(R.id.button)
        btnMove = findViewById(R.id.btnMoveToNextScreen)

        intent?.extras?.let {
            previousName = it.getString("name") ?: ""
            previousNumber = it.getString("phoneNumber") ?: ""
            System.out.println("previous key $previousName $previousNumber")
        }

        etname?.setText(previousName)

        confirmbutton.setOnClickListener {
            Log.e(TAG, "${etname?.text}")
            Toast.makeText(this, "This is toast ${etname?.text}", Toast.LENGTH_LONG).show()
        }

        btnMove?.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
