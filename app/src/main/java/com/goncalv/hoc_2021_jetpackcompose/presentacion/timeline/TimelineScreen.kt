package com.goncalv.hoc_2021_jetpackcompose.presentacion.timeline

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Add
import androidx.compose.runtime.Composable
import com.goncalv.hoc_2021_jetpackcompose.data.initialPosts
import com.goncalv.hoc_2021_jetpackcompose.dominio.Post
import com.goncalv.hoc_2021_jetpackcompose.presentacion.post.PostItem

@Composable
fun TimelineScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Row { Text("HoC 2021 Jetpack Compose") } },
                navigationIcon = null,
                actions = {
                    IconButton(
                        onClick = {},
                        content = {
                            Icon(imageVector = (Icons.Default.Search), contentDescription = null)
                        }
                    )
                }
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = { /* TODO */ },
                text = { Text("Add a new post") },
                icon = { Icon(imageVector = Icons.Outlined.Add, contentDescription = null) })
        },
        floatingActionButtonPosition = FabPosition.End
    ) {
        TimelineList(listOfPosts = initialPosts)
    }
}

@Composable
fun TimelineList(listOfPosts: List<Post>) {
    LazyColumn {
        items(listOfPosts) { post ->
            PostItem(post = post)
        }
    }
}

