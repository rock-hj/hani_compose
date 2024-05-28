package com.hanix.compose.hw

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hanix.compose.hw.ui.theme.Hw_ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Hw_ComposeTheme {
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {
    var shouldShowOnboarding by remember { mutableStateOf(true) } // value 를 계속 입력하지 않게 하기 위함

    Surface(modifier) {
        if (shouldShowOnboarding) {
            OnboardingScreen(
                modifier = modifier.fillMaxSize(),
                onContinueClick = { shouldShowOnboarding = false })
        } else {
            Column(modifier = modifier) {
                for (name in listOf("Hani", "Compose\nHappy")) {
                    Greeting(name = name)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
    val extraPadding = if (expanded) 48.dp else 0.dp

    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Text(text = "Hello ")
                    Text(text = name)
                }
                ElevatedButton(onClick = { expanded = !expanded }) {
                    Text(text = if (expanded) "Show less" else "Show more")
                }
            }
            if (expanded) {
                Text(text = "more text", modifier = Modifier.padding(vertical = 20.dp))
            }
        }

    }
}

@Composable
fun OnboardingScreen(modifier: Modifier = Modifier, onContinueClick: () -> Unit) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Welcome to the basics Codelab!")
        Button(
            modifier = Modifier.padding(vertical = 24.dp),
            onClick = onContinueClick
        ) {
            Text("Continue")
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun GreetingPreview() {
    Hw_ComposeTheme {
        Greeting("Hani")
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview() {
    Hw_ComposeTheme {
        OnboardingScreen(onContinueClick = {})
    }
}

@Preview
@Composable
fun MyAppPreview() {
    Hw_ComposeTheme {
        MyApp(Modifier.fillMaxSize())
    }
}