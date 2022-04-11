package com.example.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class MainActivity : AppCompatActivity() {


    private val users = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        users.add(User("ander2812", "123456789"))
        users.add(User("beta@gmail.com", "aplicacionesmoviles"))
        users.add(User("alfa@gmail.com", "aplicacionesmoviles"))

        loginButton.setOnClickListener {

            val intent = Intent(this, PublicationActivity::class.java)

            intent.putExtra("username", userText.text.toString())

            startActivity(intent)

            val user = User(userText.text.toString(),passwordTest.text.toString())

            var temp = false
            print(user)

            for (i in users){
                if(user.username.equals(i.username) && user.password.equals(i.password)){
                    print(temp)
                    temp = true


                }
            }

            if(temp){
                startActivity(Intent(this, MainActivity2::class.java))
            }
        }
    }
}