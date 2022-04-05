package com.example.app

import android.widget.ImageView

class Home {

    var username: String
    var likes: Int
    var description: String
    //var image: ImageView

    constructor(likes: Int, username: String, description: String){
        this.likes = likes
        this.username = username
        this.description = description
        //this.image = image
    }
}