package com.example.beautyapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.beautyapp.ui.*
import com.example.beautyapp.ui.components.*

@Composable
fun FavoritesScreen(onNavClick: (BottomNavItem) -> Unit = {}) {
    Scaffold(
        topBar = { TopBar("Favorites") },
        bottomBar = { BottomNavBar(selected = BottomNavItem.Favorites, onItemClick = onNavClick) }
    ) { padding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .background(White)
                .padding(padding)
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(vertical = 12.dp)
        ) {
            items(sampleProducts) { product ->
                ProductCard(product = product)
            }
        }
    }
}
