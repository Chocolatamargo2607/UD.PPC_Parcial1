package com.example.udppc_parcial1.view.ui.theme


import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Modifier
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Index(navController: NavController){

    val context = LocalContext.current
    var query by remember {mutableStateOf("")}
    var active by remember {mutableStateOf(false)}
    val onSearch: (String) -> Unit = {
        Toast.makeText(context, query, Toast.LENGTH_SHORT).show()
        active=false
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Save New Song")
        }
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Practice Maraca")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Practice Tambor/Drum")
            }
        }

        SearchBar(
            query = query,
            onQueryChange = {query=it},
            onSearch = onSearch ,
            active = active,
            onActiveChange = {active=it},
            placeholder = {Text(text = "Search")},
            trailingIcon = {
                IconButton(
                    onClick = { onSearch(query)},
                    enabled = query.isNotEmpty()
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null
                    )
                }
            }
        ) {

        }
    }

}

@Preview(showBackground = true)
@Composable
fun Index_preview() {
    Index(NavController(LocalContext.current))
}