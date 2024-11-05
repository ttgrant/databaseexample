package org.database.example

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Home(loggedIn: Boolean, setScreenState: (Screen) -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        Text(
            modifier = Modifier.padding(bottom = 32.dp),
            text = "North Avenue Automotive",
            fontSize = 32.sp
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (loggedIn) {
                Button(
                    modifier = Modifier.padding(end = 16.dp),
                    onClick = {
                        setScreenState(Screen.SEARCH)
                    },
                    content = {
                        Text(
                            text = "Search",
                            fontSize = 32.sp
                        )
                    }
                )
                Button(
                    onClick = {
                        setScreenState(Screen.REPORT)
                    },
                    content = {
                        Text(
                            text = "Reports",
                            fontSize = 32.sp
                        )
                    }
                )
            } else {
                Button(
                    onClick = {
                        setScreenState(Screen.LOGIN)
                    },
                    content = {
                        Text(
                            text = "Login",
                            fontSize = 32.sp
                        )
                    }
                )
            }
        }
    }
}