package com.example.beautyapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.beautyapp.ui.*
import com.example.beautyapp.ui.components.*

data class Category(val name: String, val imageUrl: String)

val categories = listOf(
    Category("Skin Creams", "https://www.figma.com/api/mcp/asset/274ff8df-a410-460e-b6ef-24825880e61d"),
    Category("Lipsticks", "https://www.figma.com/api/mcp/asset/63bea3c2-9a20-4644-930f-0468956aa8bb"),
    Category("Hair Care", "https://www.figma.com/api/mcp/asset/274ff8df-a410-460e-b6ef-24825880e61d"),
    Category("Makeup", "https://www.figma.com/api/mcp/asset/63bea3c2-9a20-4644-930f-0468956aa8bb"),
    Category("Perfumes", "https://www.figma.com/api/mcp/asset/274ff8df-a410-460e-b6ef-24825880e61d"),
    Category("Tools", "https://www.figma.com/api/mcp/asset/63bea3c2-9a20-4644-930f-0468956aa8bb"),
    Category("Eyes", "https://www.figma.com/api/mcp/asset/274ff8df-a410-460e-b6ef-24825880e61d"),
    Category("Nails", "https://www.figma.com/api/mcp/asset/63bea3c2-9a20-4644-930f-0468956aa8bb"),
)

@Composable
fun CategoriesScreen(onNavClick: (BottomNavItem) -> Unit = {}) {
    Scaffold(
        topBar = { TopBar("Categories") },
        bottomBar = { BottomNavBar(selected = BottomNavItem.Categories, onItemClick = onNavClick) }
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
            items(categories) { category ->
                CategoryCard(category)
            }
        }
    }
}

@Composable
fun CategoryCard(category: Category) {
    Box(
        modifier = Modifier
            .width(163.dp)
            .height(144.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(CardBg)
            .clickable { },
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            model = category.imageUrl,
            contentDescription = category.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Black.copy(alpha = 0.3f))
        )
        Text(
            text = category.name,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = White,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}
