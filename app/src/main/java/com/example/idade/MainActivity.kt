package com.example.idade

import android.R
import android.R.attr.bottom
import android.R.attr.fontWeight
import android.R.attr.letterSpacing
import android.R.attr.onClick
import android.R.attr.text
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
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

    var idade by remember {
        mutableIntStateOf(0)
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .padding(top = 50.dp)

        ){
            Text(
                modifier = Modifier,
                text = "Qual e a sua Idade",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Blue,
                textAlign = TextAlign.Center,

                )
        }

        Box(
            modifier = Modifier
                .padding(top = 40.dp),
        ){
            Text(
                modifier = Modifier,
                text = "Aperte os botoes para informar a sua idade",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        }
        Box(
            modifier = Modifier

                .height(60.dp)
                .padding(top = 15.dp)
                .width(60.dp),
               contentAlignment = Alignment.Center
        ){
            Text(
                modifier = Modifier,
                text = "$idade",
                textAlign = TextAlign.Center,
                fontSize = 40.sp

            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            horizontalArrangement = Arrangement.spacedBy(50.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Button(
                onClick = {idade --},
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
            ) {
                Column(
                    modifier = Modifier
                        .height(50.dp)
                        .width(50.dp)
                        .paddingFromBaseline(bottom = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "-",
                        fontSize = 30.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                }
            }

            Button(
                onClick = {idade ++},
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
            ) {
                Column(
                    modifier = Modifier
                        .height(50.dp)
                        .width(50.dp)
                        .paddingFromBaseline(bottom = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "+",
                        fontSize = 30.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                }


            }

        }
        val status = when  (idade){
            in 0 .. 17 -> "Menor"
            in 18 .. 180 -> "Maior"
            else -> if (idade == -1){
                idade ++
            }else{
                idade --
            }
        }

        Text(
            modifier = Modifier
                .padding(top = 30.dp),

            text = "Voce é $status de idade",
            textAlign = TextAlign.Center,
            fontSize = 30.sp,

        )
    }

}


