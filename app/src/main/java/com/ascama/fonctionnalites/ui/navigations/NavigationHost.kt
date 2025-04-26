package com.ascama.fonctionnalites.ui.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ascama.fonctionnalites.HomeScreen
import com.ascama.fonctionnalites.ui.screens.PDFReaderScreen


@Composable
fun NavigationHost (navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "Home"
    ) {
        composable("Home"){ HomeScreen(navController) }
        composable(route = "PDFReader/{fileName}",

            ) { backStackEntry ->
            val fileName = backStackEntry.arguments?.getString("fileName") ?: ""
            PDFReaderScreen(fileName = fileName)
        }


    }
}