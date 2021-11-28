package com.goncalv.hoc_2021_jetpackcompose.dominio

data class Post(
    val id: Int,
    val author: User,
    val postImageId: Int,
    var likedBy: List<User>
)
