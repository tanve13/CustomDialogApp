package com.tanveer.customdialogapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.tanveer.customdialogapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
         val btnMainSubmit = findViewById<Button>(R.id.btnMainSubmit)
        btnMainSubmit?.setOnClickListener{
           Dialog(this).apply {
             setContentView(R.layout.layout_dialog)
             show()
             val etEnter_Name = this.findViewById<EditText>(R.id.etEnter_Name)
             val btnSubmit: Button = this.findViewById(R.id.btnSubmit)
             val btnCancel: Button = this.findViewById(R.id.btnCancel)
             btnSubmit?.setOnClickListener {
                 if (etEnter_Name?.text?.toString().isNullOrEmpty()) {
                     etEnter_Name?.error = resources.getString(R.string.enter_name)
                 } else {
                     binding?.etEnter?.setText(etEnter_Name?.text?.toString())
                     this.dismiss()
                 }
             }
             btnCancel.setOnClickListener{
                 this.dismiss()
             }
           }
        }
    }
}