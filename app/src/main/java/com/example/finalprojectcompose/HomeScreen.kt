package com.example.beautyapp.ui.screens

import androidx.compose.foundation.background
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.beautyapp.ui.*
import com.example.beautyapp.ui.components.*

val sampleProducts = listOf(
    Product("Device Laser Hair Rem...", "Qmele", "\$18", "\$20", "%20", "70 sold", "https://www.figma.com/api/mcp/asset/274ff8df-a410-460e-b6ef-24825880e61d"),
    Product("Device Laser Hair Rem...", "Qmele", "\$10", "\$15", "%33", "50 sold", "https://www.figma.com/api/mcp/asset/274ff8df-a410-460e-b6ef-24825880e61d"),
    Product("Device Laser Hair Rem...", "Qmele", "\$10", "\$15", "%50", "50 sold", "https://www.figma.com/api/mcp/asset/274ff8df-a410-460e-b6ef-24825880e61d"),
    Product("Device Laser Hair Rem...", "Qmele", "\$10", "\$15", "%33", "50 sold", "https://www.figma.com/api/mcp/asset/274ff8df-a410-460e-b6ef-24825880e61d"),
    Product("Device Laser Hair Rem...", "Qmele", "\$10", "\$15", "%33", "50 sold", "https://www.figma.com/api/mcp/asset/274ff8df-a410-460e-b6ef-24825880e61d"),
    Product("Device Laser Hair Rem...", "Qmele", "\$10", "\$15", "%33", "50 sold", "https://www.figma.com/api/mcp/asset/274ff8df-a410-460e-b6ef-24825880e61d"),
)

@Composable
fun HomeScreen(onNavClick: (BottomNavItem) -> Unit = {}) {
    Scaffold(
        topBar = { TopBar("Good morning") },
        bottomBar = { BottomNavBar(selected = BottomNavItem.Home, onItemClick = onNavClick) }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(White)
                .padding(padding)
        ) {
            BannerSection()
            Spacer(modifier = Modifier.height(8.dp))
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 13.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(vertical = 8.dp)
            ) {
                items(sampleProducts) { product ->
                    ProductCard(product = product)
                }
            }
        }
    }
}

@Composable
fun BannerSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(166.dp)
    ) {
        AsyncImage(
            model = "https://www.figma.com/api/mcp/asset/63bea3c2-9a20-4644-930f-0468956aa8bb",
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Black.copy(alpha = 0.25f))
        )

        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 16.dp, bottom = 16.dp)
        ) {
            Text(text = "lipsticks set", fontSize = 16.sp, fontWeight = FontWeight.Medium, color = Black)
            Text(text = "\$10", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = RedMain)
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = {},
                modifier = Modifier.height(44.dp),
                shape = RoundedCornerShape(6.dp),
                colors = ButtonDefaults.buttonColors(containerColor = RedMain),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                Text(text = "Shop Now", fontSize = 13.sp, color = White)
            }
        }
    }
}
