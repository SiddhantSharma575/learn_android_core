package com.example.firstapp

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_toast.*

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//
//        btn_submit.setOnClickListener {
//            val firstName = firstName.text.toString()
//            val lastName = lastName.text.toString()
//            val birthDate = birthDate.text.toString()
//            val country = country.text.toString()
//            Log.d("MainActivity", "${firstName} ${lastName} born on ${birthDate} & lives in ${country}")
//            nane_text_view.text  = "${firstName} ${lastName} born on ${birthDate} & lives in ${country}"
//            imageView.setImageResource(R.drawable.user)
//        }

//        order_btn.setOnClickListener {
//            val checkedRadioButtonId = radio_group.checkedRadioButtonId
//            val meat = findViewById<RadioButton>(checkedRadioButtonId)
//            val cheese = cb_cheese.isChecked
//            val onions = cb_onion.isChecked
//            val salad = cb_salad.isChecked
//            val orderString = "You Ordered a burger with : \n" +
//                     "${meat.text}" +
//                    (if(cheese) "\n cheese" else "") +
//                    (if(onions) "\n onions" else "") +
//                    (if(salad) "\n salad" else "");
//
//            order_view.text = orderString
//        }

//        show_toast.setOnClickListener {
////            Toast.makeText(this, "hello",Toast.LENGTH_LONG).show()
//            Toast(this).apply {
//                duration = Toast.LENGTH_LONG
//                view = layoutInflater.inflate(R.layout.custom_toast,cltoast)
//                show()
//            }
//        }

//        show_toast.setOnClickListener {
//            Intent(this,SecondActivity::class.java).also {
//                startActivity(it)
//            }
//        }
//

//        submit.setOnClickListener {
//            val name = name.text.toString()
//            val age = age.text.toString().toInt()
//            val country = country.text.toString()
//            val person = Person(name,age,country)
//            Intent(this,SecondActivity::class.java).also {
//                it.putExtra("EXTRA_PERSON", person)
//                startActivity(it)
//            }
//        }

        permission_ask.setOnClickListener {
            requestPermissions()
        }



    }

    private fun hasWriteExternalStoragePermission() =
        ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
    private fun hasLocationForegroundPermission() =
        ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
    private fun haslocationBackgroundPermission() =
        ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_BACKGROUND_LOCATION) == PackageManager.PERMISSION_GRANTED

    @RequiresApi(Build.VERSION_CODES.Q)
    private fun requestPermissions() {
        var permissionToRequest = mutableListOf<String>()
        if(!hasWriteExternalStoragePermission()) {
            permissionToRequest.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }
        if(!hasLocationForegroundPermission()) {
            permissionToRequest.add(Manifest.permission.ACCESS_COARSE_LOCATION)
        }
        if(!haslocationBackgroundPermission()) {
            permissionToRequest.add(Manifest.permission.ACCESS_BACKGROUND_LOCATION)
        }
        if(permissionToRequest.isNotEmpty()){
            ActivityCompat.requestPermissions(this,permissionToRequest.toTypedArray(),0)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == 0 && grantResults.isNotEmpty()) {
            for (i in grantResults.indices){
                if(grantResults[i] == PackageManager.PERMISSION_GRANTED){
                    Log.d("Permission Request", "${permissions[i]} granted")
                }
            }
        }
    }

}