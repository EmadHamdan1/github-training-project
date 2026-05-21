package com.example.beautyapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.beautyapp.ui.*
import com.example.beautyapp.ui.components.*

@Composable
fun ProductDetailScreen(onNavClick: (BottomNavItem) -> Unit = {}) {
    var quantity by remember { mutableStateOf(1) }

    Scaffold(
        bottomBar = { BottomNavBar(selected = BottomNavItem.Home, onItemClick = onNavClick) }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(White)
                .padding(padding)
                .verticalScroll(rememberScrollState())
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(338.dp)
            ) {
                AsyncImage(
                    model = "https://www.figma.com/api/mcp/asset/274ff8df-a410-460e-b6ef-24825880e61d",
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.fillMaxSize()
                )
                IconButton(
                    onClick = {},
                    modifier = Modifier.align(Alignment.TopEnd).padding(8.dp)
                ) {
                    Icon(Icons.Outlined.FavoriteBorder, contentDescription = "Favorite", tint = RedMain)
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "\$14.00", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = RedMain)

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        IconButton(onClick = { if (quantity > 1) quantity-- }, modifier = Modifier.size(28.dp)) {
                            Text(text = "-", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Black)
                        }
                        Text(text = "$quantity", fontSize = 16.sp, fontWeight = FontWeight.Medium, color = Black)
                        IconButton(onClick = { quantity++ }, modifier = Modifier.size(28.dp)) {
                            Text(text = "+", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Black)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Filled.Star, contentDescription = null, tint = RedMain, modifier = Modifier.size(16.dp))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = "4.8", fontSize = 14.sp, color = Black)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "|", fontSize = 14.sp, color = DividerGray)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "50 Orders", fontSize = 14.sp, color = TextGray)
                }

                Spacer(modifier = Modifier.height(16.dp))
                HorizontalDivider(color = DividerGray)
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Applicable : 100~240V working voltage, suitable for all the countries in the world. Painless: Adjustable optimal energy level according to the skin tolerance. Providing the gentle treatment painlessly and easily , without hurting the skin.",
                    fontSize = 13.sp,
                    color = Black,
                    lineHeight = 20.sp
                )

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = {},
                    modifier = Modifier.fillMaxWidth().height(48.dp),
                    shape = RoundedCornerShape(6.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = RedMain)
                ) {
                    Text(text = "Buy now", fontSize = 18.sp, color = White)
                }
            }
        }
    }
}
