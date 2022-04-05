package com.example.app

import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HomeView(itemView: View) : RecyclerView.ViewHolder(itemView) {


    var textLike : TextView = itemView.findViewById(R.id.textLike)
    var textUser : TextView = itemView.findViewById(R.id.textUser)
    var textDescription : TextView = itemView.findViewById(R.id.textDescription)
    var imageHeart : ImageView = itemView.findViewById(R.id.imageHeart)
    var imageComment : ImageView = itemView.findViewById(R.id.imageComment)
    var imageSend : ImageView = itemView.findViewById(R.id.imageSend)
    var likeText : TextView = itemView.findViewById(R.id.likeText)

}