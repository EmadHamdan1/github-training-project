package com.example.beautyapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.beautyapp.ui.*

enum class BottomNavItem {
    Home, Categories, Cart, Favorites, Account
}

@Composable
fun BottomNavBar(selected: BottomNavItem, onItemClick: (BottomNavItem) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(66.dp)
            .background(White),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        NavItem(Icons.Outlined.Home, Icons.Filled.Home, "Home", selected == BottomNavItem.Home) {
            onItemClick(BottomNavItem.Home)
        }
        NavItem(Icons.Outlined.GridView, Icons.Filled.GridView, "Categories", selected == BottomNavItem.Categories) {
            onItemClick(BottomNavItem.Categories)
        }
        CartNavItem(selected == BottomNavItem.Cart, cartCount = 3) {
            onItemClick(BottomNavItem.Cart)
        }
        NavItem(Icons.Outlined.FavoriteBorder, Icons.Filled.Favorite, "Favorites", selected == BottomNavItem.Favorites) {
            onItemClick(BottomNavItem.Favorites)
        }
        NavItem(Icons.Outlined.Person, Icons.Filled.Person, "Account", selected == BottomNavItem.Account) {
            onItemClick(BottomNavItem.Account)
        }
    }
}

@Composable
fun NavItem(
    outlinedIcon: ImageVector,
    filledIcon: ImageVector,
    label: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .width(60.dp)
            .clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = if (selected) filledIcon else outlinedIcon,
            contentDescription = label,
            tint = if (selected) RedMain else TextGray,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun CartNavItem(selected: Boolean, cartCount: Int, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .width(60.dp)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = if (selected) Icons.Filled.ShoppingCart else Icons.Outlined.ShoppingCart,
            contentDescription = "Cart",
            tint = if (selected) RedMain else TextGray,
            modifier = Modifier.size(24.dp)
        )
        if (cartCount > 0) {
            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .offset(x = 6.dp, y = (-4).dp)
                    .size(16.dp)
                    .clip(RoundedCornerShape(50))
                    .background(RedMain),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "$cartCount", fontSize = 10.sp, color = White)
            }
        }
    }
}
