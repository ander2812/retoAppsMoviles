package com.example.app

import android.app.Instrumentation
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.core.content.FileProvider
import com.example.app.databinding.ActivityHomeBinding
import edu.co.icesi.semana4kotlina.UtilDomi
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_home.view.*
import java.io.File
import java.util.*

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    var barViewFragment: BarViewFragment = BarViewFragment()
    private lateinit var image: ImageView
    private var file:File? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        image = findViewById(R.id.uploadImage)

        val launcher = registerForActivityResult(StartActivityForResult(), ::onResult)
        val galeryLauncher = registerForActivityResult(StartActivityForResult(), ::onGaleryResult)

        binding.openCameraImage.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            file = File("${getExternalFilesDir(null)}/photo.png")
            val uri =FileProvider.getUriForFile(this, packageName, file!!)
            intent.putExtra(MediaStore.EXTRA_OUTPUT, uri)
            Log.e(">>>", file?.path.toString())

            launcher.launch(intent)
        }

        binding.searchImage.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"

            galeryLauncher.launch(intent)

        }

        binding.arrowImage.setOnClickListener {

            val intent = Intent(this, PublicationActivity::class.java)

            intent.putExtra("image", file?.path)

            startActivity(intent)


        }

        binding.backImage.setOnClickListener {

            startActivity(Intent(this, MainActivity2::class.java))


        }


    }

    fun onGaleryResult(result: ActivityResult?){
        if (result != null) {
            if(result.resultCode == RESULT_OK){
                val uriImage = result.data?.data
                uriImage?.let {
                    val path = UtilDomi.getPath(this, uriImage)
                    file = File(path)
                    Log.e(">>>",path!!)
                    val bitmap = BitmapFactory.decodeFile(path)
                    val thumbnail = Bitmap.createScaledBitmap(bitmap, bitmap.width/4, bitmap.height/4, true)
                    binding.uploadImage.setImageBitmap(thumbnail)
                }
            }
        }

    }

    fun onResult(result: ActivityResult){
        //val bitmap = result.data?.extras?.get("data") as Bitmap
        //binding.uploadImage.setImageBitmap(bitmap)

        if(result.resultCode == RESULT_OK){
            val bitmap = BitmapFactory.decodeFile(file?.path)
            val thumbnail = Bitmap.createScaledBitmap(bitmap, bitmap.width/4, bitmap.height/4, true)
            binding.uploadImage.setImageBitmap(thumbnail)



        }else if(result.resultCode == RESULT_CANCELED){
            Toast.makeText(this, "No tomo foto", Toast.LENGTH_SHORT).show()

        }

    }
}