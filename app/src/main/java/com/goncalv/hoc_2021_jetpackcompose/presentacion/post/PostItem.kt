package com.goncalv.hoc_2021_jetpackcompose.presentacion.post

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.goncalv.hoc_2021_jetpackcompose.data.initialPosts
import com.goncalv.hoc_2021_jetpackcompose.data.users
import com.goncalv.hoc_2021_jetpackcompose.dominio.Post
import com.goncalv.hoc_2021_jetpackcompose.dominio.User
import com.goncalv.hoc_2021_jetpackcompose.ui.theme.HoC_2021_JetpackComposeTheme

@Composable
fun PostItem(
    post: Post
){
    Column{
        AuthorInfoSection(author = post.author)
        PostImage(imageId = post.postImageId)
        IconSection()
    }
}

@Composable
fun IconSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            var fav by remember { mutableStateOf(false) }
            IconToggleButton(checked = fav, onCheckedChange = { fav = it }) {
                val icon = if (fav) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder
                val tint = if (fav) Color.Red else MaterialTheme.colors.onBackground
                Icon(
                    imageVector = icon,
                    tint = tint,
                    contentDescription = null
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Outlined.MailOutline,
                    tint = MaterialTheme.colors.onBackground,
                    contentDescription = null
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Outlined.Share,
                    tint = MaterialTheme.colors.onBackground,
                    contentDescription = null
                )
            }
        }
        var star by remember { mutableStateOf(false) }
        IconToggleButton(checked = star, onCheckedChange = { star = it }) {
            val icon = if (star) Icons.Filled.Star else Icons.Outlined.Star
            val tint = if (star) Color(0xFFD4AF37) else MaterialTheme.colors.onBackground
            Icon(
                imageVector = icon,
                tint = tint,
                contentDescription = null
            )
        }
    }
}

@Composable
fun PostImage(
    imageId: Int
) {
    Image(
        painter = painterResource(id = imageId),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun AuthorInfoSection(
    author: User
) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        RowImageWithText(
            imageId = author.avatarId,
            text = author.name,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
        IconButton(
            modifier = Modifier.align(Alignment.CenterVertically),
            onClick = { /* TODO */ }
        ) {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = null
            )
        }
    }
}

@Composable
fun RowImageWithText(
    imageId: Int,
    text: String,
    modifier: Modifier
) {
    Row(
        modifier = modifier,
    ) {
        Image(
            painter = painterResource(id = imageId),
            modifier = modifier
                .size(40.dp)
                .clip(CircleShape),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Text(
            text = text,
            style = MaterialTheme.typography.body1,
            modifier = modifier
                .padding(8.dp)
        )
    }
}
@Preview(showBackground = true)
@Composable
fun PostItemPreview() {
    HoC_2021_JetpackComposeTheme {
        PostItem(initialPosts.first())
    }
}

@Preview(showBackground = true)
@Composable
fun PostItemBigPreview() {
    HoC_2021_JetpackComposeTheme() {
        PostItem(initialPosts[1])
    }
}

@Preview(showBackground = true)
@Composable
fun PostItemDarkPreview() {
    HoC_2021_JetpackComposeTheme(darkTheme = true) {
        PostItem(initialPosts.first())
    }
}

@Preview(showBackground = true)
@Composable
fun AuthorInfoSectionPreview() {
    HoC_2021_JetpackComposeTheme() {
        AuthorInfoSection(users.first())
    }
}

@Preview(showBackground = true)
@Composable
fun AuthorInfoSectionDarkPreview() {
    HoC_2021_JetpackComposeTheme(darkTheme = true) {
        AuthorInfoSection(users.first())
    }
}
