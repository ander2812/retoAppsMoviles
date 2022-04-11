package com.example.app

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView

class UserFragment : Fragment() {
    private lateinit var exitButton: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.userfragment, container, false)

        exitButton = view.findViewById(R.id.exitButton)

        exitButton.setOnClickListener {

            val intent = Intent(this.activity, MainActivity::class.java)
            startActivity(intent)
        }

        return view
    }

    companion object {
        fun newInstance() = UserFragment()

    }
}