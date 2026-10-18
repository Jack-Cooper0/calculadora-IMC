package org.insbaixcamp.imcjc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.insbaixcamp.imcjc.ui.theme.ImcJCTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ImcJCTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BMIScreen()
                }
            }
        }
    }
}

@Composable
fun BMIScreen() {

    var nom: String by remember { mutableStateOf("") }
    var pes: Int by remember { mutableStateOf(80) }
    var alsada:Int by remember { mutableStateOf(100) }
    var imc: Float by remember { mutableStateOf(0f) }
    Card(modifier = Modifier.padding(16.dp)) {
    Column() {
        Text(text = "Calculadora IMC")
        TextField(
            value = "",
            onValueChange = {nom = it},
            label = { Text(text = "nom") })
    }
    Row() {
        Text(text = "Pes: $pes Kg")
        Button(onClick = {pes++}) {
            Text(text= "+")
        }
        Button(onClick = {pes--}) {
            Text(text= "-")
        }
    }
    Text(text = "Alçada: $alsada cm")
    Slider(
        value = alsada.toFloat(),
        onValueChange = {alsada = it.toInt()},
        valueRange = 100f .. 250f,
    )
    Button(onClick = {}){
        val alsadaMetres = alsada / 100f
        imc = pes / (alsadaMetres * alsadaMetres)
        Text(text = "Calcular IMC")

    }
    if (imc != 0f) {
        Text(text = "IMC: $imc")
    }
}
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ImcJCTheme {
BMIScreen()    }
}