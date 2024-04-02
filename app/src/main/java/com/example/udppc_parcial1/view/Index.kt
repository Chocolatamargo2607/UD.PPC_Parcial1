package com.example.udppc_parcial1.view.ui.theme


import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.magnifier
import androidx.compose.ui.Modifier
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.udppc_parcial1.R
import com.example.udppc_parcial1.dataManagement.Helper
import com.example.udppc_parcial1.dataManagement.SongDTO
import com.example.udppc_parcial1.dataManagement.SongService
import com.example.udppc_parcial1.view_model.navegation.App_screens
import kotlinx.coroutines.selects.select


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Index(navController: NavController) {

    val context = LocalContext.current
    //link repo
    val repository = "https://github.com/Chocolatamargo2607/UD.PPC_Parcial1"
    val repositoryintent = remember { Intent(Intent.ACTION_VIEW, Uri.parse(repository)) }
    var query by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }
    val onSearch: (String) -> Unit = {
        Toast.makeText(context, query, Toast.LENGTH_SHORT).show()
        active = false
    }
    var songService = SongService(Helper(context))
    var songs by remember { mutableStateOf(songService.getAllCanciones()) }
    var chosenSong by remember { mutableStateOf(SongDTO(0, "", "", "")) }
    var open_Dialog by remember { mutableStateOf(false) }



    Row() {
        TopAppBar(
            title = { Text(text = "Universidad Distrital Francisco Jose De Caldas") },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary,
                titleContentColor = Color.White
            ),
            navigationIcon = {
                IconButton(onClick = { context.startActivity(repositoryintent) }) {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = null,
                        tint = Color.White
                    )

                }
            }
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_asab),
            contentDescription = "Logo ASAB"
        )
        Button(onClick = { navController.navigate(route = App_screens.Save_letter_screen.router) })
        {
            Text(text = "Save New Song")
        }
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            Button(onClick = { navController.navigate(route = App_screens.Practice_maraca_screen.router) }) {
                Text(text = "Practice Maraca")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = { navController.navigate(route = App_screens.Practice_tambor_screen.router) }) {
                Text(text = "Practice Drum")
            }
        }

        SearchBar(
            query = query,
            onQueryChange = { query = it },
            onSearch = onSearch,
            active = active,
            onActiveChange = { active = it },
            placeholder = { Text(text = "Search") },
            trailingIcon = {
                IconButton(
                    onClick = { onSearch(query) },
                    enabled = query.isNotEmpty()
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null
                    )
                }
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                LazyColumn(
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 5.dp)
                ) {
                    items(songs) { song ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(7.dp)
                                .clickable {
                                    chosenSong = song
                                    open_Dialog = true
                                }

                        ) {
                            Row(
                                modifier = Modifier.padding(8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(text = "ID: ${song.id}", modifier = Modifier.weight(1f))
                                Text(
                                    text = "Name Song: ${song.name}",
                                    modifier = Modifier.weight(3f)
                                )
                                Text(
                                    text = "Date Register: ${song.date}\n",
                                    modifier = Modifier.weight(3f)
                                )
                                IconButton(onClick = {
                                    songService.delete(song.id)
                                    songs = songService.getAllCanciones()
                                    Toast.makeText(context, "Song Deleted 0-0", Toast.LENGTH_SHORT)
                                        .show()
                                }) {
                                    Icon(Icons.Default.Delete, contentDescription = "Deleted")
                                }
                            }

                        }

                    }
                }
                if (open_Dialog){
                    AlertDialog(onDismissRequest = { open_Dialog = false },
                        title = { Text(text = chosenSong.name) },
                        text = { Text(text = chosenSong.lyric) },
                        confirmButton = {
                            Button(onClick = { open_Dialog = false }) {
                                Text("Cerrar")
                            }
                        })
                }
            }



        }
    }

}

@Preview(showBackground = true)
@Composable
fun Index_preview() {
    Index(NavController(LocalContext.current))
}