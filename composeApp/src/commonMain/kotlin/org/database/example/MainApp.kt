package org.database.example

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview

enum class Screen {
    MAIN,
    LOGIN,
    REPORT,
    SEARCH
}

@Composable
@Preview
fun MainApp() {
    MaterialTheme {
        var loggedIn by remember { mutableStateOf(false) }
        var screenState by remember { mutableStateOf(Screen.MAIN) }
        val setScreenState = { screen: Screen ->
            screenState = screen
        }
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            if (screenState != Screen.MAIN) {
                Button(
                    modifier = Modifier.align(Alignment.TopStart),
                    onClick = {
                        screenState = Screen.MAIN
                    },
                    content = {
                        Text("Back")
                    }
                )
            }
            when (screenState) {
                Screen.MAIN -> Home(loggedIn = loggedIn, setScreenState = setScreenState)
                Screen.LOGIN -> Login(
                    onLogin = {
                        loggedIn = true
                        screenState = Screen.MAIN
                    })

                Screen.REPORT -> Report()
                Screen.SEARCH -> Search()
            }
        }
    }
}




