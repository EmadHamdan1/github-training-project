package com.example.beautyapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.beautyapp.ui.*

@Composable
fun LoginScreen(onLoginClick: () -> Unit = {}) {
    var phone by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize().background(White)) {

        AsyncImage(
            model = "https://www.figma.com/api/mcp/asset/e13a5d4e-f5ef-4a6d-b486-4a378070db76",
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth().height(250.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.73f)
                .align(Alignment.BottomCenter)
                .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
                .background(Color(0xFFCFD0C3).copy(alpha = 0.6f))
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(0.dp)
        ) {
            Spacer(modifier = Modifier.height(268.dp))

            Text(
                text = "Your Phone number",
                fontSize = 14.sp,
                color = Black
            )

            Spacer(modifier = Modifier.height(8.dp))
       
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .clip(RoundedCornerShape(6.dp))
                    .background(White)
                    .border(0.7.dp, BorderGray, RoundedCornerShape(6.dp)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .width(55.dp)
                        .fillMaxHeight()
                        .background(Color(0xFFFFFFFF).copy(alpha = 0.6f)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = " +972", fontSize = 12.sp, fontWeight = FontWeight.Medium, color = Black)
                }
                OutlinedTextField(
                    value = phone,
                    onValueChange = { phone = it },
                    placeholder = {
                        Text(
                            text = "Enter Your Phone Number",
                            fontSize = 12.sp,
                            color = Black.copy(alpha = 0.5f)
                        )
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
       
            Text(
                text = "Sign in with Email",
                fontSize = 12.sp,
                color = RedMain,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = onLoginClick,
                modifier = Modifier.fillMaxWidth().height(48.dp),
                shape = RoundedCornerShape(6.dp),
                colors = ButtonDefaults.buttonColors(containerColor = RedMain)
            ) {
                Text(text = "login", fontSize = 16.sp, color = White)
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = buildAnnotatedString {
                    append("By clicking login you agree to our ")
                    withStyle(SpanStyle(color = LinkBlue)) { append("terms & conditions") }
                    append(" and ")
                    withStyle(SpanStyle(color = LinkBlue)) { append("privacy policy") }
                },
                fontSize = 12.sp,
                color = Color(0xFF5B5B5B),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(32.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                HorizontalDivider(modifier = Modifier.weight(1f), color = DividerGray)
                Text(text = "  OR  ", fontSize = 14.sp, color = Black)
                HorizontalDivider(modifier = Modifier.weight(1f), color = DividerGray)
            }

            Spacer(modifier = Modifier.height(40.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                SocialButton("https://www.figma.com/api/mcp/asset/afd06ea2-2036-442c-a875-99a0f87899e6")
                Spacer(modifier = Modifier.width(16.dp))
                SocialButton("https://www.figma.com/api/mcp/asset/6d482a33-bc26-4652-8202-373665e7a6ab")
                Spacer(modifier = Modifier.width(16.dp))
                SocialButton("https://www.figma.com/api/mcp/asset/4b4bad94-40d2-49e3-9cd3-644ed9ab5979")
            }
        }
    }
}

@Composable
fun SocialButton(imageUrl: String) {
    Box(
        modifier = Modifier
            .size(48.dp)
            .clip(RoundedCornerShape(50))
            .background(White)
            .clickable { },
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = null,
            modifier = Modifier.size(48.dp)
        )
    }
}
