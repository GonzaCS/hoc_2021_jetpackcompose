package com.goncalv.hoc_2021_jetpackcompose.data

import com.goncalv.hoc_2021_jetpackcompose.R
import com.goncalv.hoc_2021_jetpackcompose.dominio.Post
import com.goncalv.hoc_2021_jetpackcompose.dominio.User

val users = listOf(
    User(
        name= "Juan",
        avatarId = R.drawable.avatar1
    ),
    User(
        name= "Paco",
        avatarId = R.drawable.avatar2
    ),
    User(
        name= "Carla",
        avatarId = R.drawable.avatar3
    ),
    User(
        name= "Sonia",
        avatarId = R.drawable.avatar4
    ),
    User(
        name= "Carlos",
        avatarId = R.drawable.avatar5
    )
)

val initialPosts = listOf(
    Post(
        id = 1,
        postImageId = R.drawable.lisboa,
        author = users[0],
        likedBy = listOf(users[1])
    ),
    Post(
        id = 2,
        postImageId = R.drawable.madrid,
        author = users[1],
        likedBy = listOf(users[2])
    ),
    Post(
        id = 3,
        postImageId = R.drawable.paris,
        author = users[2],
        likedBy = listOf(users[3])
    ),
    Post(
        id = 4,
        postImageId = R.drawable.londres,
        author = users[3],
        likedBy = listOf(users[4])
    ),Post(
        id = 5,
        postImageId = R.drawable.roma,
        author = users[4],
        likedBy = listOf(users[0])
    )

)