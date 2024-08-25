package com.example.healthappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.healthappcompose.ui.theme.HealthAppComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HealthAppComposeTheme {

            }
        }
    }
}
@Composable
fun SearchBar(modifier: Modifier = Modifier){
    TextField(value = ""
        , onValueChange = {}
        , modifier = modifier
            .heightIn(min = 56.dp)
            .fillMaxWidth(),
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search ,
                contentDescription = null)
        } ,
        placeholder = {
            Text(text = "Search" )
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.surface,
            unfocusedLabelColor = MaterialTheme.colorScheme.surface,
        )
    )
    
}
@Preview
@Composable
fun SearchBarPreview(){
    SearchBar()
}
