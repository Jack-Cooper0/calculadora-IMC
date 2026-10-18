package org.insbaixcamp.imcjc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.insbaixcamp.imcjc.ui.theme.ImcJCTheme
import org.insbaixcamp.imcjc.ui.theme.VikingAmber
import org.insbaixcamp.imcjc.ui.theme.VikingBackground
import org.insbaixcamp.imcjc.ui.theme.VikingFrost
import org.insbaixcamp.imcjc.ui.theme.VikingGold
import org.insbaixcamp.imcjc.ui.theme.VikingGoldBorder
import org.insbaixcamp.imcjc.ui.theme.VikingGoldDark
import org.insbaixcamp.imcjc.ui.theme.VikingGreen
import org.insbaixcamp.imcjc.ui.theme.VikingRed
import org.insbaixcamp.imcjc.ui.theme.VikingSurface
import org.insbaixcamp.imcjc.ui.theme.VikingTextMuted
import org.insbaixcamp.imcjc.ui.theme.VikingTextParchment
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ImcJCTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BMIScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun BMIScreen(modifier: Modifier = Modifier) {
    var nom by remember { mutableStateOf("") }
    var pes by remember { mutableIntStateOf(80) }
    var alsada by remember { mutableIntStateOf(175) }
    var imc by remember { mutableFloatStateOf(0f) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(VikingBackground)
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        // Encapçalament estil Runes / Valhalla
        Text(
            text = "ᛏ  VALHALLA IMC  ᛏ",
            style = MaterialTheme.typography.labelLarge,
            color = VikingGoldBorder,
            letterSpacing = 4.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "⚔️ CALCULADORA DEL GUERRER ⚔️",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.ExtraBold,
            color = VikingGold,
            textAlign = TextAlign.Center
        )

        Text(
            text = "Mesura la teva massa per a la batalla",
            style = MaterialTheme.typography.bodyMedium,
            color = VikingTextMuted,
            fontStyle = FontStyle.Italic
        )

        // Secció 1: Nom del Guerrer
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = VikingSurface),
            border = BorderStroke(2.dp, VikingGoldBorder),
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "🪓 Nom del Guerrer / Guerrera",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = VikingGold
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = nom,
                    onValueChange = { nom = it },
                    label = { Text("Escriu el teu nom de batalla...", color = VikingTextMuted) },
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = VikingGold,
                        unfocusedBorderColor = VikingGoldBorder,
                        focusedTextColor = VikingTextParchment,
                        unfocusedTextColor = VikingTextParchment,
                        cursorColor = VikingGold
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        // Secció 2: Pes (Massa de batalla)
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = VikingSurface),
            border = BorderStroke(2.dp, VikingGoldBorder),
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "🛡️ Pes (Massa de batalla)",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = VikingGold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "$pes kg",
                    style = MaterialTheme.typography.displayMedium,
                    fontWeight = FontWeight.Black,
                    color = VikingTextParchment
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    FilledTonalButton(
                        onClick = { if (pes > 1) pes-- },
                        colors = ButtonDefaults.filledTonalButtonColors(
                            containerColor = VikingGoldDark,
                            contentColor = VikingTextParchment
                        ),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(text = "🛡️ -1 kg", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    FilledTonalButton(
                        onClick = { pes++ },
                        colors = ButtonDefaults.filledTonalButtonColors(
                            containerColor = VikingGoldDark,
                            contentColor = VikingTextParchment
                        ),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(text = "⚔️ +1 kg", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    }
                }
            }
        }

        // Secció 3: Alçada (Estatura)
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = VikingSurface),
            border = BorderStroke(2.dp, VikingGoldBorder),
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "🏹 Alçada (Estatura)",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = VikingGold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "$alsada cm",
                    style = MaterialTheme.typography.displayMedium,
                    fontWeight = FontWeight.Black,
                    color = VikingTextParchment
                )
                Spacer(modifier = Modifier.height(4.dp))
                Slider(
                    value = alsada.toFloat(),
                    onValueChange = { alsada = it.toInt() },
                    valueRange = 100f..220f,
                    colors = SliderDefaults.colors(
                        thumbColor = VikingGold,
                        activeTrackColor = VikingGoldBorder,
                        inactiveTrackColor = VikingGoldDark
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        // Botó Principal: FORJAR IMC
        Button(
            onClick = {
                val alsadaMetres = alsada / 100f
                if (alsadaMetres > 0) {
                    imc = pes / (alsadaMetres * alsadaMetres)
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = VikingGold,
                contentColor = VikingBackground
            ),
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(2.dp, VikingTextParchment),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
            Text(
                text = "⚡ FORJAR IMC EN EL FOC ⚡",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Black,
                letterSpacing = 1.sp
            )
        }

        // Resultat de la Consulta als Déus
        if (imc > 0f) {
            val (categoria, consell, color) = when {
                imc < 18.5f -> Triple(
                    "❄️ Guerrer d'Hivern (Pes insuficient)",
                    "\"Necessites més hidromel i carn de senglar per resistir la batalla!\"",
                    VikingFrost
                )
                imc < 25.0f -> Triple(
                    "⚔️ Digne de Valhalla! (Pes ideal)",
                    "\"Forma física perfecta per liderar la teva tropa al combat!\"",
                    VikingGreen
                )
                imc < 30.0f -> Triple(
                    "🛡️ Força de Berserker! (Sobrepes)",
                    "\"Poder brut devastador, ideal per a les primeres línies del front!\"",
                    VikingAmber
                )
                else -> Triple(
                    "🌋 Gegant de Gel - Jötunn (Obesitat)",
                    "\"Possedeixes la massa colossal d'un Jötunn capaç de tremolar la terra!\"",
                    VikingRed
                )
            }

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = VikingSurface),
                border = BorderStroke(3.dp, color),
                shape = RoundedCornerShape(12.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "᛭ ᚢ ᚦ ᚨ ᚱ ᚴ ᚷ ᚹ ᛭",
                        color = VikingGoldBorder,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    if (nom.isNotBlank()) {
                        Text(
                            text = "Hail, Guerrer $nom!",
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.Bold,
                            color = VikingGold,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                    }

                    Text(
                        text = "VERDICTE DELS DÉUS (IMC):",
                        style = MaterialTheme.typography.labelMedium,
                        color = VikingTextMuted,
                        letterSpacing = 2.sp
                    )

                    Text(
                        text = String.format(Locale.getDefault(), "%.1f", imc),
                        style = MaterialTheme.typography.displayLarge,
                        fontWeight = FontWeight.Black,
                        color = color
                    )

                    Text(
                        text = categoria,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = color,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = consell,
                        style = MaterialTheme.typography.bodyMedium,
                        color = VikingTextParchment,
                        textAlign = TextAlign.Center,
                        fontStyle = FontStyle.Italic
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ImcJCTheme {
        BMIScreen()
    }
}
