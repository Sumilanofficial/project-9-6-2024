package com.matrix.swiggyloginpage

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
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
    private var etemail:EditText?=null
    private var etfindus:EditText?=null
    private var btnyes:RadioButton?=null
    private var btncontinne:Button?=null


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
        etemail=findViewById(R.id.etemail)
        etfindus=findViewById(R.id.etfindus)
        btnyes=findViewById(R.id.btnyes)
        btncontinne=findViewById(R.id.btncontinue)

        confirmbutton?.setOnClickListener {
            var name=etname?.text
            var collage=etcollage?.text
            var number=etphonenumber?.text
            var email=etemail?.text
            var valid=true


            Toast.makeText(this, "$name ,$collage,$number,$email", Toast.LENGTH_LONG).show()

            if (etphonenumber?.text.toString().isEmpty()) {
                etphonenumber?.error = "Enter your Number"
                valid=false
            } else if (etphonenumber?.text.toString().trim().length < 10) {
                etphonenumber?.error = "Enter a valid number "
                valid=false
            }
            if (etname?.text.toString().isEmpty()) {
                etname?.error = "Enter your Name"
                valid=false
            }
            if (etcollage?.text.toString().isEmpty()) {
                etcollage?.error = "Enter your Collage"
                valid=false

            }
            if (etemail?.text.toString().isEmpty()) {
                etemail?.error = "Enter your Email"
                valid=false
            }
            if (valid){
                Toast.makeText(this,"Details Entered Successfully",Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(this,"Invalid Submittion",Toast.LENGTH_LONG).show()
            }
        }
    btnyes?.setOnCheckedChangeListener { buttonView, isChecked ->
        if (isChecked){
            etfindus?.visibility= View.VISIBLE
        }
        else{
            etfindus?.visibility=View.GONE
        }
    }
      btncontinne?.setOnClickListener {
          var intent=Intent(this,MainActivity2::class.java)
          startActivity(intent)
      }










    }
}

