package com.addindev.simplelist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.layout.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.addindev.simplelist.ui.theme.SimpleListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleListTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Content()
                }
            }
        }
    }
}

data class PostItem(val name: String, @DrawableRes val image: Int)

@Composable
fun Content() {

    val posts: List<PostItem> = listOf(
        PostItem("Black Hole", R.drawable.planet),
        PostItem("Wojak Guts", R.drawable.g),
        PostItem("Purple Supra", R.drawable.purple),
        PostItem("Rei", R.drawable.r),
        PostItem("Supra MK3", R.drawable.s),
        PostItem("Guts", R.drawable.gats),
        PostItem("Building", R.drawable.bg),
        PostItem("Black Hole", R.drawable.planet),
        PostItem("Wojak Guts", R.drawable.g),
        PostItem("Purple Supra", R.drawable.purple),
        PostItem("Rei", R.drawable.r),
        PostItem("Supra MK3", R.drawable.s),
        PostItem("Guts", R.drawable.gats),
        PostItem("Building", R.drawable.bg)
    )

    Column {
    TopAppBar(
        title = {
            Text("Simple List")
        }
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(items = posts) { post ->
            ItemList(postItem = post)
        }
    }
    }
}

@Composable
fun ItemList(postItem: PostItem, modifier: Modifier = Modifier) {
    Row(
        modifier
            .padding(horizontal = 8.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(MaterialTheme.colors.surface)
            .clickable { }
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(
                id = postItem.image),
            contentDescription = "image",
            contentScale = ContentScale.FillBounds,
           modifier = Modifier
               .size(50.dp)
               .clip(CircleShape)
       )
        Column(
        modifier = Modifier
            .padding(start = 8.dp)
            .align(alignment = Alignment.CenterVertically)
            .weight(1f)
    ) {
        Text(postItem.name, fontWeight = FontWeight.Bold)
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Text("3 minutes ago", style = MaterialTheme.typography.body2)
        }
    }
    }
}

@Preview(showBackground = true)
@Composable
fun ContentPreview() {
    SimpleListTheme {
        Content()
    }
}