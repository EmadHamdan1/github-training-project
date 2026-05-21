package com.example.beautyapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.beautyapp.ui.*

@Composable
fun EditProfileScreen(onDoneClick: () -> Unit = {}) {
    var name by remember { mutableStateOf("Mona Fadl Al-Harthy") }
    var phone by remember { mutableStateOf("00966 5211043") }
    var email by remember { mutableStateOf("Mona Fadl@gmail.com") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .padding(horizontal = 16.dp, vertical = 24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "Your Name", fontSize = 14.sp, color = Black)

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .clip(RoundedCornerShape(6.dp)),
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = BorderGray,
                focusedBorderColor = RedMain
            )
        )

        Text(text = "Your Phone number", fontSize = 14.sp, color = Black)

        OutlinedTextField(
            value = phone,
            onValueChange = { phone = it },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .clip(RoundedCornerShape(6.dp)),
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = BorderGray,
                focusedBorderColor = RedMain
            )
        )

        Text(text = "Your Email Address", fontSize = 14.sp, color = Black)

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .clip(RoundedCornerShape(6.dp)),
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = BorderGray,
                focusedBorderColor = RedMain
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = onDoneClick,
            modifier = Modifier.fillMaxWidth().height(48.dp),
            shape = RoundedCornerShape(6.dp),
            colors = ButtonDefaults.buttonColors(containerColor = RedMain)
        ) {
            Text(text = "Done", fontSize = 16.sp, fontWeight = FontWeight.Medium, color = White)
        }
    }
}
