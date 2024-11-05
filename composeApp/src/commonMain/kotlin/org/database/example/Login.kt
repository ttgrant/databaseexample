package org.database.example

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Login(onLogin: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        var username by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var error by remember { mutableStateOf(false) }

        Text(
            modifier = Modifier.padding(bottom = 32.dp),
            text = "Login",
            fontSize = 32.sp
        )
        TextField(
            label = {
                Text(text = "Username", color = if (error) Color.Red else Color.Black)
            },
            value = username,
            onValueChange = { username = it },
            isError = error,
        )
        TextField(
            label = {
                Text(text = "Password", color = if (error) Color.Red else Color.Black)
            },
            value = password,
            onValueChange = { valueChange -> password = valueChange },
            isError = error,
        )
        Button(
            onClick = {
                if (username.isEmpty() || password.isEmpty()) {
                    error = true
                } else {
                    error = false
                    onLogin.invoke()
                }
            },
            content = {
                Text("Log in")
            }
        )

    }
}