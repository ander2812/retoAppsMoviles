package com.example.app

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.app.databinding.ActivityPublicationBinding
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_publication.*
import kotlinx.android.synthetic.main.userfragment.view.*
import java.util.*

class PublicationActivity : AppCompatActivity() {

    private lateinit var image: ImageView
    private lateinit var mainActivity: MainActivity
    private lateinit var barViewFragment: BarViewFragment
    private val binding: ActivityPublicationBinding by lazy {
        ActivityPublicationBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        barViewFragment = BarViewFragment()
        mainActivity = MainActivity()


        val path = intent.extras?.getString("image")

        val bitmap = BitmapFactory.decodeFile(path)
        val sbitmap = Bitmap.createScaledBitmap(bitmap, bitmap.width/2, bitmap.height/2, true)

        binding.publicationImage.setImageBitmap(sbitmap)

        binding.checkImage2.setOnClickListener{
            val username = intent.extras?.getString("username")
            val publication = Home(UUID.randomUUID().toString(), 0, username.toString(), publicationImage, descriptionText.toString())
            print(username.toString())
            barViewFragment.registerPublication(publication)

            intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)

        }

        binding.backArrowImage.setOnClickListener {
            intent = Intent(this, HomeActivity:: class.java)
            startActivity(intent)
        }
    }
}