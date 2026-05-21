package com.example.beautyapp

import androidx.compose.runtime.*
import com.example.beautyapp.ui.components.BottomNavItem
import com.example.beautyapp.ui.screens.*

@Composable
fun BeautyApp() {
    var currentScreen by remember { mutableStateOf("splash") }
    var currentNav by remember { mutableStateOf(BottomNavItem.Home) }

    when (currentScreen) {
        "splash" -> {
            SplashScreen()
            LaunchedEffect(Unit) {
                kotlinx.coroutines.delay(2000)
                currentScreen = "login"
            }
        }
        "login" -> LoginScreen(onLoginClick = { currentScreen = "main" })
        "main" -> when (currentNav) {
            BottomNavItem.Home -> HomeScreen(onNavClick = { currentNav = it })
            BottomNavItem.Categories -> CategoriesScreen(onNavClick = { currentNav = it })
            BottomNavItem.Cart -> CartScreen(onNavClick = { currentNav = it })
            BottomNavItem.Favorites -> FavoritesScreen(onNavClick = { currentNav = it })
            BottomNavItem.Account -> AccountScreen(onNavClick = { currentNav = it })
        }
    }
}
