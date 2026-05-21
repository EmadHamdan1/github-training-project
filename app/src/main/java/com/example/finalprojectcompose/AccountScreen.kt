package com.example.beautyapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.beautyapp.ui.*
import com.example.beautyapp.ui.components.*

@Composable
fun AccountScreen(onNavClick: (BottomNavItem) -> Unit = {}) {
    Scaffold(
        topBar = { TopBar(" Account ") },
        bottomBar = { BottomNavBar(selected = BottomNavItem.Account, onItemClick = onNavClick) }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(White)
                .padding(padding)
                .padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(15.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(BgGray),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Outlined.Person, contentDescription = null, modifier = Modifier.size(36.dp), tint = TextGray)
                }
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(text = "Mona Fadl Al-Harthy", fontSize = 16.sp, fontWeight = FontWeight.Medium, color = Black)
                    Text(text = "Mona Fadl@gmail.com", fontSize = 13.sp, color = TextGray)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(color = DividerGray)
            Spacer(modifier = Modifier.height(8.dp))

            AccountMenuItem(icon = Icons.Outlined.ShoppingCart, label = "My orders", badge = "4")
            AccountMenuItem(icon = Icons.Outlined.ShoppingCart, label = "Payment method")
            AccountMenuItem(icon = Icons.Outlined.LocationOn, label = "Shipping address")

            Spacer(modifier = Modifier.height(8.dp))
            HorizontalDivider(color = DividerGray)
            Spacer(modifier = Modifier.height(8.dp))

            AccountMenuItem(icon = Icons.Outlined.ShoppingCart, label = "Questions and answers")
            AccountMenuItem(icon = Icons.Outlined.ShoppingCart, label = "Invite friends")

            Spacer(modifier = Modifier.height(8.dp))
            HorizontalDivider(color = DividerGray)
            Spacer(modifier = Modifier.height(8.dp))

            AccountMenuItem(icon = Icons.Outlined.Settings, label = "Settings")
            AccountMenuItem(icon = Icons.Outlined.Close, label = "Logout")
        }
    }
}

@Composable
fun AccountMenuItem(icon: ImageVector, label: String, badge: String? = null) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(44.dp)
            .clickable { },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = icon, contentDescription = label, tint = Black, modifier = Modifier.size(20.dp))
        Spacer(modifier = Modifier.width(12.dp))
        Text(text = label, fontSize = 14.sp, color = Black, modifier = Modifier.weight(1f))
        if (badge != null) {
            Box(
                modifier = Modifier
                    .size(20.dp)
                    .clip(RoundedCornerShape(50))
                    .background(RedMain),
                contentAlignment = Alignment.Center
            ) {
                Text(text = badge, fontSize = 12.sp, color = White)
            }
        }
        Icon(Icons.Outlined.ShoppingCart, contentDescription = null, tint = TextGray, modifier = Modifier.size(18.dp))
    }
}
