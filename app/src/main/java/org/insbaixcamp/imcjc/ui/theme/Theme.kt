package org.insbaixcamp.imcjc.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val VikingColorScheme = darkColorScheme(
    primary = VikingGold,
    onPrimary = VikingBackground,
    primaryContainer = VikingGoldDark,
    onPrimaryContainer = VikingTextParchment,
    secondary = VikingGoldBorder,
    onSecondary = VikingBackground,
    tertiary = VikingRed,
    onTertiary = VikingTextParchment,
    background = VikingBackground,
    onBackground = VikingTextParchment,
    surface = VikingSurface,
    onSurface = VikingTextParchment,
    surfaceVariant = VikingSurfaceVariant,
    onSurfaceVariant = VikingTextParchment,
    outline = VikingGoldBorder,
)

@Composable
fun ImcJCTheme(
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = VikingColorScheme,
        typography = Typography,
        content = content,
    )
}
