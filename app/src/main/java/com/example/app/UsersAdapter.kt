package com.example.app

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class UsersAdapter : RecyclerView.Adapter<HomeView>() {

    private val publications = ArrayList<Home>()

    fun addPublication(home: Home){
        publications.add(home)
        print(publications)
        notifyItemInserted(publications.size-1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeView {

        var inflater =LayoutInflater.from(parent.context)
        val row = inflater.inflate(R.layout.contactrow, parent, false)
        val homeView = HomeView(row)
        return homeView

    }

    override fun onBindViewHolder(skeleton: HomeView, position: Int) {
        
        val publication = publications[position]
        skeleton.textLike.text = publication.likes.toString()
        skeleton.textUser.text = publication.username
        skeleton.textDescription.text = publication.description
        skeleton.likeText.text

    }

    override fun getItemCount(): Int {
        return publications.size    }
    }