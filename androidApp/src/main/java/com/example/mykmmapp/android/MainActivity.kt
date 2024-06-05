package com.example.mykmmapp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.mykmmapp.Greeting

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingApp()
                }
            }
        }
    }
}

@Composable
fun GreetingApp() {
    var name by remember { mutableStateOf("") }
    var greetingMessage by remember { mutableStateOf(Greeting().greet()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = greetingMessage)
        Spacer(modifier = Modifier.height(16.dp))
        BasicTextField(
            value = name,
            onValueChange = { name = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(Color.LightGray)
                .padding(16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            greetingMessage = if (name.isNotEmpty()) {
                "Hello, $name!"
            } else {
                Greeting().greet()
            }
        }) {
            Text("Click me!")
        }
    }
}

@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingApp()
    }
}

