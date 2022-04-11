package com.example.app

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi

class UploadImage : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_image)

        requestPermissions(arrayOf(
            Manifest.permission.CAMERA,
            Manifest.permission.CALL_PHONE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        ), 1 )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == 1){
            var allGrant = true
            for (result in grantResults){
                Log.e(">>>",""+result)
                if (result == PackageManager.PERMISSION_DENIED) allGrant = false
            }

            if (allGrant){
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()


            }else{
                Toast.makeText(this, "Tiene que aceptar todos los permisos para continuar", Toast.LENGTH_SHORT).show()
            }
        }
    }
}