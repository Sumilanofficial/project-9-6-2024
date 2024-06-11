package com.matrix.swiggyloginpage

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var confirmbutton: Button? = null
    private var etphonenumber: EditText? = null
    private var etname: EditText? = null
    private var etcollage: EditText? = null
    private var etemail: EditText? = null
    private var etfindus: EditText? = null
    private var btnyes: RadioButton? = null
    private var btnno: RadioButton? = null
    private var btncontinne: Button? = null
    private var rgenrol: RadioGroup? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        confirmbutton = findViewById(R.id.confirmbutton)
        etphonenumber = findViewById(R.id.etphonenumber)
        etname = findViewById(R.id.etname)
        etcollage = findViewById(R.id.etcollage)
        etemail = findViewById(R.id.etemail)
        etfindus = findViewById(R.id.etfindus)
        btnyes = findViewById(R.id.btnyes)
        btnno = findViewById(R.id.btnno)
        rgenrol = findViewById(R.id.rgenrol)

        confirmbutton?.setOnClickListener {
            if (etname?.text?.toString()?.trim().isNullOrEmpty()) {
                etname?.error = "Enter your Name"
            } else if (etcollage?.text?.toString()?.trim().isNullOrEmpty()) {
                etcollage?.error = "Enter your Collage"
            } else if (etphonenumber?.text.toString().trim().isNullOrEmpty()) {
                etphonenumber?.error = "Enter your Number"
            } else if (etphonenumber?.text.toString().trim().length < 10) {
                etphonenumber?.error = "Enter a valid number of 10 digits"
            } else if (etemail?.text?.toString()?.trim().isNullOrEmpty()) {
                etemail?.error = "Enter your Email"
            } else if (rgenrol?.checkedRadioButtonId == -1) {
                Toast.makeText(this, "Select one option", Toast.LENGTH_LONG).show()
            } else if (btnyes?.isChecked == true && etfindus?.text?.toString()?.trim().isNullOrEmpty()) {
                etfindus?.error = "Enter how did you find us?"
            } else {
                var intent = Intent(this, MainActivity2::class.java)
                intent.putExtra("name", etname?.text.toString().trim())
                intent.putExtra("phoneNumber", etphonenumber?.text.toString().trim())
                startActivity(intent)
            }
        }

        btnyes?.setOnClickListener {}

        btnyes?.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                etfindus?.visibility = View.VISIBLE
            } else {
                etfindus?.visibility = View.GONE
            }
        }

    }
}
