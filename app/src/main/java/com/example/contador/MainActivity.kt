package com.example.contador

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.contador.ui.theme.ContadorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContadorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    contador(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun contador(modifier: Modifier = Modifier) {

    var count by remember { mutableStateOf(0) }

    fun aumentar() {
        count++
    }
    fun diminuir() {
        count--
    }

    Column(
        modifier = modifier.fillMaxSize().background(color = Color(0xffFFCBDB)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Contador: $count",
            fontSize = 40.sp,
            color = Color.DarkGray,
            modifier = modifier
        )

        Spacer(modifier = Modifier.height(20.dp))


        Button(onClick = { aumentar() }) {
            Text(text = "Clique para aumentar")
        }

        Button(onClick = { diminuir() }) {
            Text(text = "Clique para diminuir")
        }
    }
}