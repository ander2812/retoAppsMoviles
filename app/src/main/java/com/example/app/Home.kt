package com.example.app

import android.widget.ImageView

class Home {

    var username: String
    var likes: Int
    var description: String
    var id: String
    var image: ImageView

    constructor(id: String, likes: Int, username: String, image: ImageView, description: String){
        this.likes = likes
        this.username = username
        this.description = description
        this.id = id
        this.image = image
    }
}