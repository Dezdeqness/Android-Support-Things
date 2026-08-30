package com.dezdeqness.ast.viewbook.core.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.dezdeqness.ast.viewbook.core.viewcase.ViewCase
import com.dezdeqness.core.ui.theme.AppTheme

data class ViewCaseStateHolder(
    val stateMap: MutableMap<String, Any>,
    val viewCaseId: String
)

val LocalViewCaseState = compositionLocalOf<ViewCaseStateHolder> {
    error("No ViewCaseState provided")
}

private enum class DevicePreset(val label: String, val portraitWidth: Dp, val portraitHeight: Dp) {
    Phone("Phone", 400.dp, 840.dp),
    Tablet("Tablet", 680.dp, 1040.dp),
}

private enum class Orientation(val label: String) {
    Portrait("Portrait"),
    Landscape("Landscape"),
}

private enum class ContentAlignment(val label: String, val alignment: Alignment) {
    TopStart("↖", Alignment.TopStart),
    TopCenter("↑", Alignment.TopCenter),
    TopEnd("↗", Alignment.TopEnd),
    CenterStart("←", Alignment.CenterStart),
    Center("●", Alignment.Center),
    CenterEnd("→", Alignment.CenterEnd),
    BottomStart("↙", Alignment.BottomStart),
    BottomCenter("↓", Alignment.BottomCenter),
    BottomEnd("↘", Alignment.BottomEnd),
}

private val fontScaleOptions = listOf(0.75f, 1.0f, 1.25f, 1.5f, 1.75f, 2.0f, 2.25f)
private val defaultFontScaleIndex = fontScaleOptions.indexOf(1.0f)

@Composable
fun ViewCasePreview(
    modifier: Modifier = Modifier,
    viewCase: ViewCase,
    isDarkTheme: Boolean = false,
) {
    val state = remember(viewCase.title) { mutableStateMapOf<String, Any>() }
    val stateHolder = remember(viewCase.title) {
        ViewCaseStateHolder(state, viewCase.title)
    }

    var fontScaleIndex by remember(viewCase.title) { mutableStateOf(defaultFontScaleIndex) }
    var layoutDirection by remember(viewCase.title) { mutableStateOf(LayoutDirection.Ltr) }
    var deviceFrameEnabled by remember(viewCase.title) { mutableStateOf(false) }
    var devicePreset by remember(viewCase.title) { mutableStateOf(DevicePreset.Phone) }
    var orientation by remember(viewCase.title) { mutableStateOf(Orientation.Portrait) }
    var contentAlignment by remember(viewCase.title) { mutableStateOf(ContentAlignment.Center) }
    var contentSize by remember(viewCase.title) { mutableStateOf(IntSize.Zero) }

    CompositionLocalProvider(LocalViewCaseState provides stateHolder) {
        Row(modifier) {
            Column(modifier = Modifier.fillMaxHeight().weight(1f)) {
                Box(
                    modifier = Modifier.fillMaxSize().weight(1f).clipToBounds(),
                    contentAlignment = Alignment.Center
                ) {
                    val baseDensity = LocalDensity.current
                    AppTheme(isDarkTheme = isDarkTheme) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(AppTheme.colors.background),
                            contentAlignment = Alignment.Center,
                        ) {
                            CompositionLocalProvider(
                                LocalLayoutDirection provides layoutDirection,
                                LocalDensity provides Density(
                                    density = baseDensity.density,
                                    fontScale = fontScaleOptions[fontScaleIndex],
                                ),
                            ) {
                                val component = @Composable {
                                    Box(
                                        modifier = Modifier.onSizeChanged { contentSize = it },
                                        contentAlignment = Alignment.Center
                                    ) {
                                        viewCase.content(viewCase)
                                    }
                                }

                                val alignedComponent = @Composable {
                                    Box(
                                        modifier = Modifier.fillMaxSize(),
                                        contentAlignment = contentAlignment.alignment,
                                    ) {
                                        component()
                                    }
                                }

                                if (deviceFrameEnabled) {
                                    DeviceFrame(
                                        preset = devicePreset,
                                        orientation = orientation,
                                    ) { alignedComponent() }
                                } else {
                                    alignedComponent()
                                }
                            }
                        }
                    }
                }
                HorizontalDivider()
                SizeReadout(size = contentSize)
            }

            VerticalDivider()

            Inspector(
                viewCase = viewCase,
                fontScaleIndex = fontScaleIndex,
                onFontScaleSelected = { fontScaleIndex = it },
                layoutDirection = layoutDirection,
                onLayoutDirectionSelected = { layoutDirection = it },
                deviceFrameEnabled = deviceFrameEnabled,
                onDeviceFrameToggled = { deviceFrameEnabled = it },
                devicePreset = devicePreset,
                onDevicePresetSelected = { devicePreset = it },
                orientation = orientation,
                onOrientationSelected = { orientation = it },
                contentAlignment = contentAlignment,
                onContentAlignmentSelected = { contentAlignment = it },
            )
        }
    }
}

@Composable
private fun DeviceFrame(
    preset: DevicePreset,
    orientation: Orientation,
    content: @Composable () -> Unit,
) {
    val portrait = orientation == Orientation.Portrait
    val frameWidth = if (portrait) preset.portraitWidth else preset.portraitHeight
    val frameHeight = if (portrait) preset.portraitHeight else preset.portraitWidth

    Column(
        modifier = Modifier
            .padding(16.dp)
            .width(frameWidth)
            .heightIn(max = frameHeight)
            .fillMaxHeight()
            .clip(RoundedCornerShape(28.dp))
            .background(AppTheme.colors.background)
            .border(
                width = 6.dp,
                color = AppTheme.colors.textPrimary,
                shape = RoundedCornerShape(28.dp)
            )
            .padding(6.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = "9:41",
                style = AppTheme.typography.labelSmall,
                color = AppTheme.colors.textPrimary,
            )
            Text(
                text = "•••",
                style = AppTheme.typography.labelSmall,
                color = AppTheme.colors.textPrimary,
            )
        }
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            content()
        }
    }
}

@Composable
private fun SizeReadout(size: IntSize) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp),
        contentAlignment = Alignment.CenterEnd,
    ) {
        Text(
            text = "${size.width} × ${size.height} px",
            style = AppTheme.typography.labelSmall,
            color = AppTheme.colors.textSecondary,
        )
    }
}

@Composable
private fun Inspector(
    viewCase: ViewCase,
    fontScaleIndex: Int,
    onFontScaleSelected: (Int) -> Unit,
    layoutDirection: LayoutDirection,
    onLayoutDirectionSelected: (LayoutDirection) -> Unit,
    deviceFrameEnabled: Boolean,
    onDeviceFrameToggled: (Boolean) -> Unit,
    devicePreset: DevicePreset,
    onDevicePresetSelected: (DevicePreset) -> Unit,
    orientation: Orientation,
    onOrientationSelected: (Orientation) -> Unit,
    contentAlignment: ContentAlignment,
    onContentAlignmentSelected: (ContentAlignment) -> Unit,
) {
    val parameters = viewCase.parameters()

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .width(280.dp)
            .background(AppTheme.colors.surface)
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        InspectorSection(title = "STATE") {
            AxisChips(
                label = "font",
                options = fontScaleOptions.map { it.toString() },
                selectedIndex = fontScaleIndex,
                onSelected = onFontScaleSelected,
            )
            AxisChips(
                label = "layoutDirection",
                options = listOf("LTR", "RTL"),
                selectedIndex = if (layoutDirection == LayoutDirection.Ltr) 0 else 1,
                onSelected = {
                    onLayoutDirectionSelected(
                        if (it == 0) LayoutDirection.Ltr else LayoutDirection.Rtl
                    )
                },
            )
        }

        InspectorSection(title = "CANVAS") {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "Device frame",
                    style = AppTheme.typography.bodyMedium,
                    color = AppTheme.colors.textPrimary,
                )
                Switch(checked = deviceFrameEnabled, onCheckedChange = onDeviceFrameToggled)
            }
            AxisChips(
                label = "device",
                options = DevicePreset.entries.map { it.label },
                selectedIndex = DevicePreset.entries.indexOf(devicePreset),
                onSelected = { onDevicePresetSelected(DevicePreset.entries[it]) },
            )
            AxisChips(
                label = "orientation",
                options = Orientation.entries.map { it.label },
                selectedIndex = Orientation.entries.indexOf(orientation),
                onSelected = { onOrientationSelected(Orientation.entries[it]) },
            )
            AlignmentGrid(
                selected = contentAlignment,
                onSelected = onContentAlignmentSelected,
            )
        }

        if (parameters.isNotEmpty()) {
            InspectorSection(title = "PARAMETERS") {
                ParametersContent(parameters = parameters)
            }
        }
    }
}

@Composable
private fun InspectorSection(
    title: String,
    content: @Composable () -> Unit,
) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text(
            text = title,
            style = AppTheme.typography.labelMedium,
            fontWeight = FontWeight.Bold,
            color = AppTheme.colors.textSecondary,
        )
        HorizontalDivider()
        content()
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun AxisChips(
    label: String,
    options: List<String>,
    selectedIndex: Int,
    onSelected: (Int) -> Unit,
) {
    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
        Text(
            text = label,
            style = AppTheme.typography.bodySmall,
            color = AppTheme.colors.textSecondary,
        )
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            options.forEachIndexed { index, option ->
                val selected = index == selectedIndex
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(
                            if (selected) AppTheme.colors.primary else AppTheme.colors.surfaceVariant
                        )
                        .clickable { onSelected(index) }
                        .padding(horizontal = 10.dp, vertical = 6.dp),
                ) {
                    Text(
                        text = option,
                        style = AppTheme.typography.labelSmall,
                        color = if (selected) AppTheme.colors.onPrimary else AppTheme.colors.textPrimary,
                    )
                }
            }
        }
    }
}

@Composable
private fun AlignmentGrid(
    selected: ContentAlignment,
    onSelected: (ContentAlignment) -> Unit,
) {
    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
        Text(
            text = "alignment",
            style = AppTheme.typography.bodySmall,
            color = AppTheme.colors.textSecondary,
        )
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            ContentAlignment.entries.chunked(3).forEach { row ->
                Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    row.forEach { option ->
                        val isSelected = option == selected
                        Box(
                            modifier = Modifier
                                .size(36.dp)
                                .clip(RoundedCornerShape(6.dp))
                                .background(
                                    if (isSelected) AppTheme.colors.primary else AppTheme.colors.surfaceVariant
                                )
                                .clickable { onSelected(option) },
                            contentAlignment = Alignment.Center,
                        ) {
                            Text(
                                text = option.label,
                                style = AppTheme.typography.bodyMedium,
                                color = if (isSelected) AppTheme.colors.onPrimary else AppTheme.colors.textPrimary,
                            )
                        }
                    }
                }
            }
        }
    }
}

