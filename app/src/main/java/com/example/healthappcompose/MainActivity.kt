package com.example.healthappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.healthappcompose.ui.theme.HealthAppComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HealthAppComposeTheme {
                MySootheAppPortrait()

            }
        }
    }
}

@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    TextField(
        value = "", onValueChange = {}, modifier = modifier
            .heightIn(min = 56.dp)
            .fillMaxWidth(),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
        placeholder = {
            Text(text = "Search")
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.surface,
            unfocusedLabelColor = MaterialTheme.colorScheme.surface,
        )
    )

}

@Composable
fun AlignYourBodyElement(modifier: Modifier = Modifier,drawable: Int, text: String) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape),
        )
        Text(text = text, color = Color.Black)

    }

}

@Composable
fun FavoriteCollectionCard(
    modifier: Modifier = Modifier,
) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(255.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.img_1),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(80.dp)
            )
            Text(
                text = stringResource(R.string.nature_meditations),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}
@Composable
fun AlignYourBodyRow(modifier: Modifier = Modifier , alignYourBodyData: List<AlignYourBodyData>) {
LazyRow(
    horizontalArrangement = Arrangement.spacedBy(8.dp),
    contentPadding = PaddingValues(horizontal = 16.dp),
    modifier = modifier
){
   items(items = alignYourBodyData){ item: AlignYourBodyData ->
       AlignYourBodyElement(drawable = item.img, text = item.title, )

   }

}
}
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(modifier.verticalScroll(rememberScrollState())) {
        Spacer(Modifier.height(16.dp))
        SearchBar(Modifier.padding(horizontal = 16.dp))
        HomeSection(title = R.string.align_your_body) {
            AlignYourBodyRow(alignYourBodyData = listOf(
                AlignYourBodyData(R.drawable.img, "Inversions"),
                AlignYourBodyData(R.drawable.img_2, "Quick yoga"),
                AlignYourBodyData(R.drawable.img_3, "Stairs"),
                AlignYourBodyData(R.drawable.img_1, "Inversions"),
                AlignYourBodyData(R.drawable.img_2, "Quick yoga"),
                AlignYourBodyData(R.drawable.img_3, "Stairs"),
            ),)
        }
        HomeSection(title = R.string.favorite_collections) {
            FavoriteCollectionsGrid(alignYourBodyData = listOf(
                AlignYourBodyData(R.drawable.img, "Inversions"),
                AlignYourBodyData(R.drawable.img_2, "Quick yoga"),
                AlignYourBodyData(R.drawable.img_3, "Stairs"),
                AlignYourBodyData(R.drawable.img_1, "Nature meditations"),
                AlignYourBodyData(R.drawable.img_2, "Quick yoga"),
                AlignYourBodyData(R.drawable.img_3, "Stairs"),
            ),)
        }
        Spacer(Modifier.height(16.dp))
    }
}
@Composable
fun HomeSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        Text(
            text = stringResource(title),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
                .padding(horizontal = 16.dp)
        )
        content()
    }
}
@Composable
fun FavoriteCollectionsGrid( modifier: Modifier = Modifier,
                             alignYourBodyData: List<AlignYourBodyData>){
    LazyHorizontalGrid(rows = GridCells.Fixed(2) ,
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.height(168.dp)
        ) {
        items(items = alignYourBodyData) { item ->
            Surface(
                shape = MaterialTheme.shapes.medium,
                color = MaterialTheme.colorScheme.surfaceVariant,
                modifier = modifier
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.width(255.dp)
                ) {
                    Image(
                        painter = painterResource(item.img),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(80.dp)
                    )
                    Text(
                        text =item.title,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }
            }
        }

    }
}

@Composable
private fun SootheBottomNavigation(modifier: Modifier = Modifier){
    NavigationBar(modifier = modifier,
        containerColor = MaterialTheme.colorScheme.surfaceVariant,) {
        NavigationBarItem(selected = true,
            onClick = { },
            label = {
                Text(
                    text = "Home"
                )
            },
            icon = {Icon(
            imageVector = Icons.Default.Favorite,
            contentDescription = null,
                )
            },
            )
        NavigationBarItem(selected = false,
            onClick = { },
            label = {
                Text(
                    text = "Profile"
                )
            },
            icon = {Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = null,
            )
            },
        )

    }
}
@Composable
fun MySootheAppPortrait() {

    Scaffold(
            bottomBar = { SootheBottomNavigation() }
        ) { padding ->
            HomeScreen(Modifier.padding(padding))
        }

}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun FavoriteCollectionCardPreview() {
    FavoriteCollectionCard(
    )

}
@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE, heightDp = 180)
@Composable
fun ScreenContentPreview() {
  HomeScreen()
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun AlignYourBodyElementPreview() {
    AlignYourBodyRow(alignYourBodyData = listOf(
        AlignYourBodyData(R.drawable.img, "Inversions"),
        AlignYourBodyData(R.drawable.img_2, "Quick yoga"),
        AlignYourBodyData(R.drawable.img_3, "Stairs"),
        AlignYourBodyData(R.drawable.img_1, "Inversions"),
        AlignYourBodyData(R.drawable.img_2, "Quick yoga"),
        AlignYourBodyData(R.drawable.img_3, "Stairs"),
    ),)
}
@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun FavoriteCollectionsGridPreview() {
    FavoriteCollectionsGrid(alignYourBodyData = listOf(
        AlignYourBodyData(R.drawable.img, "Inversions"),
        AlignYourBodyData(R.drawable.img_2, "Quick yoga"),
        AlignYourBodyData(R.drawable.img_3, "Stairs"),
        AlignYourBodyData(R.drawable.img_1, "Nature meditations"),
        AlignYourBodyData(R.drawable.img_2, "Quick yoga"),
        AlignYourBodyData(R.drawable.img_3, "Stairs"),
    ),)
}

@Preview
@Composable
fun SearchBarPreview() {
    SearchBar()
}
