package com.example.idade

import android.R.attr.fontWeight
import android.R.attr.letterSpacing
import android.R.attr.text
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.idade.ui.theme.IdadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IdadeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    sobreIdade(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun sobreIdade(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .background(Color.Gray)
                .padding(top = 50.dp)

        ){
            Text(
                modifier = Modifier
                    .background(Color.Green),
                text = "Qual e a sua Idade",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Blue,
                textAlign = TextAlign.Center,

                )
        }

        Box(
            modifier = Modifier
                .background(Color.Gray)
                .padding(top = 20.dp),


        ){
            Text(
                modifier = Modifier
                    .background(Color.Yellow),

                text = "Aperte os botoes para informar a sua idade",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
            )
        }
    }

}

@Composable
fun acaoBotao(modifier: Modifier = Modifier) {

    Column(
        modifier = Modifier
            .background(Color.Magenta),
        verticalArrangement = Arrangement.spacedBy(16.dp)

    ) {

        var idade by remember {
            mutableStateOf("")
        }
    }
}

