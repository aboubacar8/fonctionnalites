package com.ascama.fonctionnalites.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ascama.fonctionnalites.ui.navigations.NavigationHost
import com.ascama.fonctionnalites.ui.theme.FonctionnalitesTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModalNavigationView(navHostController: NavHostController) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val listItemBottomBar = rememberSaveable {
        listOf(
            "Home" to Icons.Default.Home,
            "Notification" to Icons.Default.Notifications,
            "Setting" to Icons.Default.Settings,
            "Profile" to Icons.Default.Person
        )
    }


    val drawerWidth = 0.8f

    ModalNavigationDrawer(
        gesturesEnabled = true,
        drawerState = drawerState,
        drawerContent = {
         DrawerContent {
             scope.launch { drawerState.close() }
         }
        }
    ) {
        Scaffold(
            topBar = {

                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(Color.Magenta),
                    title = {
                        Text(text = "Fonctionnalités", color = White, textAlign = TextAlign.Center )
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                scope.launch { drawerState.open() }
                            }
                        ) {
                            Icon(
                                Icons.Default.Menu,
                                contentDescription = "Menu",
                                tint = White
                            )
                        }
                    },
                    actions = {
                        IconButton(
                            onClick = {
                               // scope.launch { drawerState.open() }

                            }
                        ) {
                            Icon(
                                Icons.Default.MoreVert,
                                contentDescription = "Menu",
                                tint = White
                            )
                        }
                    },
                    modifier = Modifier.zIndex(1f)
                )
            },
            bottomBar = {
                BottomAppBar(
                    containerColor = Color.Magenta
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxSize(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {


                       listItemBottomBar.forEach { item->
                           Column(
                               modifier = Modifier
                                   .padding(8.dp)
                                   .weight(1f, fill = false)
                                   .clickable(onClick = {}),
                               verticalArrangement = Arrangement.Center,
                               horizontalAlignment = Alignment.CenterHorizontally
                           ) {
                               Icon(
                                   imageVector = item.second,
                                   contentDescription = item.first,
                                   tint =  White,
                                   modifier = Modifier
                                       .size(24.dp)

                               )

                               Text(
                                   text = item.first,
                                   style = MaterialTheme.typography.labelMedium,
                                   color = White
                               )
                           }

                       }
                    }
                }
            }
        ) {innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                NavigationHost(navHostController)
            }
        }
    }
}


@Composable
fun DrawerContent(onClose : () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth(0.75f)
            .fillMaxHeight()
            .background(White),

    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .padding(bottom = 32.dp)
                .background(Color.Magenta)
        )

        Text(
            text = "Accueil",
            style = MaterialTheme.typography.titleLarge,
            color = Color.Magenta,
           // modifier = Modifier.clickable(onClick = {navHostController.navigate("PDFReader/revision_et_reference.pdf")})
        )

        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Parametres",
            style = MaterialTheme.typography.titleLarge,
            color = Color.Magenta
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Profil",
            style = MaterialTheme.typography.titleLarge,
            color = Color.Magenta
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Langue",
            style = MaterialTheme.typography.titleLarge,
            color = Color.Magenta
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ModalNavigationPreview() {
    FonctionnalitesTheme {
        val navHostController = rememberNavController()
        ModalNavigationView(navHostController)
       // DrawerContent()
    }
}