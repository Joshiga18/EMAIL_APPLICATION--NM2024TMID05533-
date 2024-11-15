package com.example.emailapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import com.example.emailapplication.ui.theme.EmailApplicationTheme
import androidx. compose. material3.Text
import androidx. compose. material3.Button
import androidx. compose. material3.ButtonDefaults

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EmailApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Email(this)
                }
            }
        }
    }
}

@Composable
fun Email(context: Context) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Full-screen background image
        Image(
            painter = painterResource(id = R.drawable.home_screen),
            contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds, // Scales the image to fill the screen without stretching
        )

        // Overlay Column for Text at the top and Buttons at the bottom
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Text at the top
            Text(
                text = "Home Screen",
                modifier = Modifier
                    .padding(top = 24.dp)
                    .align(Alignment.CenterHorizontally), // Center text horizontally
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp
            )

            Spacer(modifier = Modifier.weight(1f)) // Spacer to push buttons to the bottom

            // Buttons at the bottom
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(bottom = 24.dp)
            ) {
                Button(
                    onClick = {
                        context.startActivity(
                            Intent(context, SendMailActivity::class.java)
                        )
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFadbef4))
                ) {
                    Text(
                        text = "Send Email",
                        modifier = Modifier.padding(10.dp),
                        color = Color.Black,
                        fontSize = 15.sp
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        context.startActivity(
                            Intent(context, ViewMailActivity::class.java)
                        )
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFadbef4))
                ) {
                    Text(
                        text = "View Emails",
                        modifier = Modifier.padding(10.dp),
                        color = Color.Black,
                        fontSize = 15.sp
                    )
                }
            }
        }
    }
}
