package com.dezdeqness.ast.viewbook.core.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dezdeqness.ast.viewbook.core.viewcase.ViewParameter

@Composable
fun ParametersList(
    modifier: Modifier = Modifier,
    parameters: List<ViewParameter>
) {
    Column(
        modifier = modifier
            .fillMaxHeight()
            .width(280.dp)
            .background(MaterialTheme.colorScheme.surface)
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Parameters",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface
        )

        HorizontalDivider()

        parameters.forEach { parameter ->
            when (parameter) {
                is ViewParameter.BooleanParameter -> {
                    BooleanParameterView(parameter)
                }

                is ViewParameter.StringParameter -> {
                    StringParameterView(parameter)
                }

                is ViewParameter.IntParameter -> {
                    IntParameterView(parameter)
                }

                is ViewParameter.FloatParameter -> {
                    FloatParameterView(parameter)
                }

                is ViewParameter.ChoiceParameter -> {
                    ChoiceParameterView(parameter)
                }

                is ViewParameter.ColorParameter -> {
                    ColorParameterView(parameter)
                }

                is ViewParameter.DensityParameter -> {
                    DensityParameterView(parameter)
                }

                is ViewParameter.CustomParameter -> {
                    CustomParameterView(parameter)
                }
            }
        }
    }
}

@Composable
private fun BooleanParameterView(parameter: ViewParameter.BooleanParameter) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = parameter.label,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface
        )
        Switch(
            checked = parameter.value,
            onCheckedChange = parameter.onChange
        )
    }
}

@Composable
private fun StringParameterView(parameter: ViewParameter.StringParameter) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = parameter.label,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface
        )
        TextField(
            value = parameter.value,
            onValueChange = parameter.onChange,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
private fun IntParameterView(parameter: ViewParameter.IntParameter) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = parameter.label,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = parameter.value.toString(),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
        Slider(
            value = parameter.value.toFloat(),
            onValueChange = { parameter.onChange(it.toInt()) },
            valueRange = parameter.min.toFloat()..parameter.max.toFloat(),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
private fun FloatParameterView(parameter: ViewParameter.FloatParameter) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = parameter.label,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = parameter.value.toString(),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
        Slider(
            value = parameter.value,
            onValueChange = parameter.onChange,
            valueRange = parameter.min..parameter.max,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
private fun ChoiceParameterView(parameter: ViewParameter.ChoiceParameter) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = parameter.label,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface
        )
        parameter.options.forEachIndexed { index, option ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .clickable { parameter.onChange(index) }
                    .background(
                        if (index == parameter.selectedIndex) {
                            MaterialTheme.colorScheme.primaryContainer
                        } else {
                            MaterialTheme.colorScheme.surfaceVariant
                        }
                    )
                    .padding(horizontal = 12.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = option,
                    style = MaterialTheme.typography.bodySmall,
                    color = if (index == parameter.selectedIndex) {
                        MaterialTheme.colorScheme.onPrimaryContainer
                    } else {
                        MaterialTheme.colorScheme.onSurfaceVariant
                    }
                )
            }
        }
    }
}

@Composable
private fun ColorParameterView(parameter: ViewParameter.ColorParameter) {
    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = parameter.label,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .width(40.dp)
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(8.dp))
                    .clickable { showDialog = true }
                    .background(parseColor(parameter.value))
            )
            TextField(
                value = parameter.value,
                onValueChange = { newValue ->
                    parameter.onChange(newValue)
                },
                modifier = Modifier.weight(1f),
                placeholder = { Text("#AARRGGBB") }
            )
        }
    }

    if (showDialog) {
        ColorPickerDialog(
            currentColor = parameter.value,
            onColorSelected = { color ->
                parameter.onChange(color)
                showDialog = false
            },
            onDismiss = { showDialog = false }
        )
    }
}

@Composable
private fun DensityParameterView(parameter: ViewParameter.DensityParameter) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = parameter.label,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = "${parameter.value.toInt()} dp",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
        Slider(
            value = parameter.value,
            onValueChange = parameter.onChange,
            valueRange = parameter.min..parameter.max,
            steps = ((parameter.max - parameter.min) / parameter.step).toInt() - 1,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
private fun CustomParameterView(parameter: ViewParameter.CustomParameter) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = parameter.label,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface
        )
        parameter.content()
    }
}

private fun parseColor(hex: String): androidx.compose.ui.graphics.Color {
    return try {
        val cleanHex = hex.removePrefix("#")
        when (cleanHex.length) {
            6 -> {
                val r = cleanHex.substring(0, 2).toInt(16)
                val g = cleanHex.substring(2, 4).toInt(16)
                val b = cleanHex.substring(4, 6).toInt(16)
                androidx.compose.ui.graphics.Color(r, g, b, 255)
            }

            8 -> {
                val a = cleanHex.substring(0, 2).toInt(16)
                val r = cleanHex.substring(2, 4).toInt(16)
                val g = cleanHex.substring(4, 6).toInt(16)
                val b = cleanHex.substring(6, 8).toInt(16)
                androidx.compose.ui.graphics.Color(r, g, b, a)
            }

            else -> androidx.compose.ui.graphics.Color.Gray
        }
    } catch (e: Exception) {
        androidx.compose.ui.graphics.Color.Gray
    }
}

private fun isValidHexColor(hex: String): Boolean {
    val cleanHex = hex.removePrefix("#")
    return cleanHex.matches(Regex("^[0-9A-Fa-f]{6}$|^[0-9A-Fa-f]{8}$"))
}

@Composable
private fun ColorPickerDialog(
    currentColor: String,
    onColorSelected: (String) -> Unit,
    onDismiss: () -> Unit
) {
    var hexInput by remember { mutableStateOf(currentColor) }
    val rgba = remember(hexInput) { hexToRgba(hexInput) }
    var alpha by remember { mutableStateOf(rgba.first) }
    var red by remember { mutableStateOf(rgba.second) }
    var green by remember { mutableStateOf(rgba.third) }
    var blue by remember { mutableStateOf(rgba.fourth) }

    // Update hex when sliders change
    LaunchedEffect(alpha, red, green, blue) {
        hexInput = rgbaToHex(alpha, red, green, blue)
    }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text("Выберите цвет", style = MaterialTheme.typography.titleLarge)
        },
        text = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                // Color preview
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(80.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(parseColor(hexInput))
                            .border(
                                width = 1.dp,
                                color = MaterialTheme.colorScheme.outline,
                                shape = RoundedCornerShape(12.dp)
                            )
                    )

                    Column(modifier = Modifier.weight(1f)) {
                        TextField(
                            value = hexInput,
                            onValueChange = { newValue ->
                                hexInput = newValue
                                if (isValidHexColor(newValue)) {
                                    val newRgba = hexToRgba(newValue)
                                    alpha = newRgba.first
                                    red = newRgba.second
                                    green = newRgba.third
                                    blue = newRgba.fourth
                                }
                            },
                            modifier = Modifier.fillMaxWidth(),
                            label = { Text("HEX") },
                            singleLine = true
                        )
                    }
                }

                HorizontalDivider()

                // ARGB Sliders
                Text(
                    text = "ARGB",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold
                )

                ColorSlider(
                    label = "Alpha",
                    value = alpha,
                    onValueChange = { alpha = it },
                    color = androidx.compose.ui.graphics.Color.Gray
                )

                ColorSlider(
                    label = "Red",
                    value = red,
                    onValueChange = { red = it },
                    color = androidx.compose.ui.graphics.Color.Red
                )

                ColorSlider(
                    label = "Green",
                    value = green,
                    onValueChange = { green = it },
                    color = androidx.compose.ui.graphics.Color.Green
                )

                ColorSlider(
                    label = "Blue",
                    value = blue,
                    onValueChange = { blue = it },
                    color = androidx.compose.ui.graphics.Color.Blue
                )
            }
        },
        confirmButton = {
            TextButton(
                onClick = {
                    if (isValidHexColor(hexInput)) {
                        onColorSelected(hexInput)
                    }
                }
            ) {
                Text("Применить")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Отмена")
            }
        }
    )
}

@Composable
private fun ColorSlider(
    label: String,
    value: Int,
    onValueChange: (Int) -> Unit,
    color: androidx.compose.ui.graphics.Color
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = label,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = value.toString(),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
        Slider(
            value = value.toFloat(),
            onValueChange = { onValueChange(it.toInt()) },
            valueRange = 0f..255f,
            colors = androidx.compose.material3.SliderDefaults.colors(
                thumbColor = color,
                activeTrackColor = color.copy(alpha = 0.7f)
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

private data class Rgba(val first: Int, val second: Int, val third: Int, val fourth: Int)

private fun hexToRgba(hex: String): Rgba {
    return try {
        val cleanHex = hex.removePrefix("#")
        when (cleanHex.length) {
            6 -> {
                val r = cleanHex.substring(0, 2).toInt(16)
                val g = cleanHex.substring(2, 4).toInt(16)
                val b = cleanHex.substring(4, 6).toInt(16)
                Rgba(255, r, g, b) // Alpha = 255 (fully opaque)
            }

            8 -> {
                val a = cleanHex.substring(0, 2).toInt(16)
                val r = cleanHex.substring(2, 4).toInt(16)
                val g = cleanHex.substring(4, 6).toInt(16)
                val b = cleanHex.substring(6, 8).toInt(16)
                Rgba(a, r, g, b)
            }

            else -> Rgba(255, 128, 128, 128)
        }
    } catch (e: Exception) {
        Rgba(255, 128, 128, 128)
    }
}

private fun rgbaToHex(a: Int, r: Int, g: Int, b: Int): String {
    return if (a == 255) {
        "#%02X%02X%02X".format(r, g, b)
    } else {
        "#%02X%02X%02X%02X".format(a, r, g, b)
    }
}
