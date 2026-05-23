package com.dezdeqness.ast

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.dezdeqness.ast.viewbook.core.ViewBook
import com.dezdeqness.ast.viewbook.core.ViewBookState
import com.dezdeqness.ast.viewbook.core.ui.HierarchicalItem
import com.dezdeqness.ast.views.adaptiveLayoutDefault
import com.dezdeqness.ast.views.adaptiveViewCollectionDefault
import com.dezdeqness.ast.views.animatedLoadingBarsDefault
import com.dezdeqness.ast.views.appSectionDefault
import com.dezdeqness.ast.views.appTextFieldDefault
import com.dezdeqness.ast.views.buttonDefault
import com.dezdeqness.ast.views.buttonOutlined
import com.dezdeqness.ast.views.buttonText
import com.dezdeqness.ast.views.chipDefault
import com.dezdeqness.ast.views.diagramChartDefault
import com.dezdeqness.ast.views.emptyStateDefault
import com.dezdeqness.ast.views.errorStateDefault
import com.dezdeqness.ast.views.expandableContentDefault
import com.dezdeqness.ast.views.expandableTextDefault
import com.dezdeqness.ast.views.headerDefault
import com.dezdeqness.ast.views.headerIconLess
import com.dezdeqness.ast.views.headerSettingsColor
import com.dezdeqness.ast.views.headerSettingsDefault
import com.dezdeqness.ast.views.headerShaped
import com.dezdeqness.ast.views.horizontalChartDefault
import com.dezdeqness.ast.views.iconButtonDefault
import com.dezdeqness.ast.views.iconFilledButtonDefault
import com.dezdeqness.ast.views.iconOutlinedButtonDefault
import com.dezdeqness.ast.views.metadataRowDefault
import com.dezdeqness.ast.views.metadataRowList
import com.dezdeqness.ast.views.multiSelectDialogDefault
import com.dezdeqness.ast.views.progressSettingsDefault
import com.dezdeqness.ast.views.searchTextFieldDefault
import com.dezdeqness.ast.views.shimmerDefault
import com.dezdeqness.ast.views.shimmerOneWave
import com.dezdeqness.ast.views.singleChoiceBottomSheetDefault
import com.dezdeqness.ast.views.singleChoiceBottomSheetHeaderLess
import com.dezdeqness.ast.views.singleChoiceDialogDefault
import com.dezdeqness.ast.views.singleChoiceDialogHeaderLess
import com.dezdeqness.ast.views.switchSettingsDefault
import com.dezdeqness.ast.views.switchSettingsDisabled
import com.dezdeqness.ast.views.switchSettingsFull
import com.dezdeqness.ast.views.textSettingsDefault
import com.dezdeqness.ast.views.textSettingsDisabled
import com.dezdeqness.ast.views.textSettingsFull
import com.dezdeqness.ast.views.textSettingsPrefix
import com.dezdeqness.ast.views.textSettingsSuffix
import com.dezdeqness.ast.views.tileDefault
import com.dezdeqness.ast.views.tileFull
import com.dezdeqness.ast.views.tileNoShape
import com.dezdeqness.ast.views.tilePrefix
import com.dezdeqness.ast.views.tileSuffix
import com.dezdeqness.ast.views.toolbarDefault
import com.dezdeqness.core.ui.theme.AppTheme

@Composable
fun App() {
    val viewBookState = remember {
        ViewBookState(
            listOf(
                HierarchicalItem.Folder(
                    id = "buttons",
                    displayName = "Buttons",
                    children = listOf(
                        HierarchicalItem.Item(
                            id = "chip-default",
                            displayName = "Chip Default",
                            value = chipDefault
                        ),
                        HierarchicalItem.Item(
                            id = "button-default",
                            displayName = "Button Default",
                            value = buttonDefault
                        ),
                        HierarchicalItem.Item(
                            id = "button-outlined",
                            displayName = "Button Outlined",
                            value = buttonOutlined
                        ),
                        HierarchicalItem.Item(
                            id = "button-text",
                            displayName = "Button Text",
                            value = buttonText
                        ),
                        HierarchicalItem.Item(
                            id = "icon-filled-button-default",
                            displayName = "Icon Filled Button Default",
                            value = iconFilledButtonDefault
                        ),
                        HierarchicalItem.Item(
                            id = "icon-outlined-button-default",
                            displayName = "Icon Outlined Button Default",
                            value = iconOutlinedButtonDefault
                        ),
                        HierarchicalItem.Item(
                            id = "icon-button-default",
                            displayName = "Icon Button Default",
                            value = iconButtonDefault
                        ),
                    )
                ),
                HierarchicalItem.Folder(
                    id = "tiles",
                    displayName = "Tiles",
                    children = listOf(
                        HierarchicalItem.Item(
                            id = "tile-default",
                            displayName = "Tile Default",
                            value = tileDefault
                        ),
                        HierarchicalItem.Item(
                            id = "tile-prefix",
                            displayName = "Tile Prefix",
                            value = tilePrefix
                        ),
                        HierarchicalItem.Item(
                            id = "tile-suffix",
                            displayName = "Tile Suffix",
                            value = tileSuffix
                        ),
                        HierarchicalItem.Item(
                            id = "tile-full",
                            displayName = "Tile Full",
                            value = tileFull
                        ),
                        HierarchicalItem.Item(
                            id = "tile-no-shape",
                            displayName = "Tile No Shape",
                            value = tileNoShape
                        )
                    )
                ),
                HierarchicalItem.Folder(
                    id = "settings",
                    displayName = "Settings",
                    children = listOf(
                        HierarchicalItem.Folder(
                            id = "text-settings",
                            displayName = "Text Settings",
                            level = 1,
                            children = listOf(
                                HierarchicalItem.Item(
                                    id = "text-settings-default",
                                    displayName = "Text Settings Default",
                                    value = textSettingsDefault,
                                    level = 2
                                ),
                                HierarchicalItem.Item(
                                    id = "text-settings-disabled",
                                    displayName = "Text Settings Disabled",
                                    value = textSettingsDisabled,
                                    level = 2
                                ),
                                HierarchicalItem.Item(
                                    id = "text-settings-prefix",
                                    displayName = "Text Settings Prefix",
                                    value = textSettingsPrefix,
                                    level = 2
                                ),
                                HierarchicalItem.Item(
                                    id = "text-settings-suffix",
                                    displayName = "Text Settings Suffix",
                                    value = textSettingsSuffix,
                                    level = 2
                                ),
                                HierarchicalItem.Item(
                                    id = "text-settings-full",
                                    displayName = "Text Settings Full",
                                    value = textSettingsFull,
                                    level = 2
                                )
                            )
                        ),
                        HierarchicalItem.Folder(
                            id = "header-settings",
                            displayName = "Header Settings",
                            level = 1,
                            children = listOf(
                                HierarchicalItem.Item(
                                    id = "header-settings-default",
                                    displayName = "Header Settings Default",
                                    value = headerSettingsDefault,
                                    level = 2
                                ),
                                HierarchicalItem.Item(
                                    id = "header-settings-color",
                                    displayName = "Header Settings Color",
                                    value = headerSettingsColor,
                                    level = 2
                                )
                            )
                        ),
                        HierarchicalItem.Folder(
                            id = "switch-settings",
                            displayName = "Switch Settings",
                            level = 1,
                            children = listOf(
                                HierarchicalItem.Item(
                                    id = "switch-settings-default",
                                    displayName = "Switch Settings Default",
                                    value = switchSettingsDefault,
                                    level = 2
                                ),
                                HierarchicalItem.Item(
                                    id = "switch-settings-disabled",
                                    displayName = "Switch Settings Disabled",
                                    value = switchSettingsDisabled,
                                    level = 2
                                ),
                                HierarchicalItem.Item(
                                    id = "switch-settings-full",
                                    displayName = "Switch Settings Full",
                                    value = switchSettingsFull,
                                    level = 2
                                )
                            )
                        ),
                        HierarchicalItem.Item(
                            id = "progress-settings-default",
                            displayName = "Progress Settings Default",
                            value = progressSettingsDefault,
                            level = 1
                        ),
                        HierarchicalItem.Item(
                            id = "app-section-default",
                            displayName = "App Section Default",
                            value = appSectionDefault,
                            level = 1
                        )
                    )
                ),
                HierarchicalItem.Folder(
                    id = "headers",
                    displayName = "Headers",
                    children = listOf(
                        HierarchicalItem.Item(
                            id = "header-default",
                            displayName = "Header Default",
                            value = headerDefault
                        ),
                        HierarchicalItem.Item(
                            id = "header-icon-less",
                            displayName = "Header Icon Less",
                            value = headerIconLess
                        ),
                        HierarchicalItem.Item(
                            id = "header-shaped",
                            displayName = "Header Shaped",
                            value = headerShaped
                        )
                    )
                ),
                HierarchicalItem.Folder(
                    id = "toolbar",
                    displayName = "Toolbar",
                    children = listOf(
                        HierarchicalItem.Item(
                            id = "toolbar-default",
                            displayName = "Toolbar Default",
                            value = toolbarDefault
                        ),
                    )
                ),
                HierarchicalItem.Folder(
                    id = "text-fields",
                    displayName = "Text Fields",
                    children = listOf(
                        HierarchicalItem.Item(
                            id = "app-text-field-default",
                            displayName = "App Text Field",
                            value = appTextFieldDefault
                        ),
                        HierarchicalItem.Item(
                            id = "search-text-field-default",
                            displayName = "Search Text Field",
                            value = searchTextFieldDefault
                        ),
                    )
                ),
                HierarchicalItem.Folder(
                    id = "expandable",
                    displayName = "Expandable",
                    children = listOf(
                        HierarchicalItem.Item(
                            id = "expandable-content-default",
                            displayName = "Expandable Content",
                            value = expandableContentDefault
                        ),
                        HierarchicalItem.Item(
                            id = "expandable-text-default",
                            displayName = "Expandable Text",
                            value = expandableTextDefault
                        ),
                    )
                ),
                HierarchicalItem.Folder(
                    id = "charts",
                    displayName = "Charts",
                    children = listOf(
                        HierarchicalItem.Item(
                            id = "diagram-chart-default",
                            displayName = "Diagram Chart",
                            value = diagramChartDefault
                        ),
                        HierarchicalItem.Item(
                            id = "horizontal-chart-default",
                            displayName = "Horizontal Chart",
                            value = horizontalChartDefault
                        ),
                    )
                ),
                HierarchicalItem.Folder(
                    id = "metadata",
                    displayName = "Metadata",
                    children = listOf(
                        HierarchicalItem.Item(
                            id = "metadata-row-default",
                            displayName = "Metadata Row",
                            value = metadataRowDefault
                        ),
                        HierarchicalItem.Item(
                            id = "metadata-row-list",
                            displayName = "Metadata Row List",
                            value = metadataRowList
                        ),
                    )
                ),
                HierarchicalItem.Folder(
                    id = "dialogs",
                    displayName = "Dialogs",
                    children = listOf(
                        HierarchicalItem.Folder(
                            id = "single-choice-dialog",
                            displayName = "Single Choice Dialog",
                            level = 1,
                            children = listOf(
                                HierarchicalItem.Item(
                                    id = "single-choice-dialog-default",
                                    displayName = "Single Choice Dialog Default",
                                    value = singleChoiceDialogDefault,
                                    level = 2
                                ),
                                HierarchicalItem.Item(
                                    id = "single-choice-dialog-header-less",
                                    displayName = "Single Choice Dialog Header Less",
                                    value = singleChoiceDialogHeaderLess,
                                    level = 2
                                )
                            )
                        ),
                        HierarchicalItem.Folder(
                            id = "single-choice-bottom-sheet",
                            displayName = "Single Choice Bottom Sheet",
                            level = 1,
                            children = listOf(
                                HierarchicalItem.Item(
                                    id = "single-choice-bottom-sheet-default",
                                    displayName = "Single Choice Bottom Sheet Default",
                                    value = singleChoiceBottomSheetDefault,
                                    level = 2
                                ),
                                HierarchicalItem.Item(
                                    id = "single-choice-bottom-sheet-header-less",
                                    displayName = "Single Choice Bottom Sheet Header Less",
                                    value = singleChoiceBottomSheetHeaderLess,
                                    level = 2
                                )
                            )
                        ),
                        HierarchicalItem.Item(
                            id = "multi-select-dialog-default",
                            displayName = "Multi Select Dialog",
                            value = multiSelectDialogDefault,
                            level = 1,
                        ),
                    )
                ),
                HierarchicalItem.Folder(
                    id = "states",
                    displayName = "States",
                    level = 1,
                    children = listOf(
                        HierarchicalItem.Item(
                            id = "states-error-state",
                            displayName = "Error state",
                            value = errorStateDefault,
                            level = 2
                        ),
                        HierarchicalItem.Item(
                            id = "states-empty-state",
                            displayName = "Empty state",
                            value = emptyStateDefault,
                            level = 2
                        ),
                    ),
                ),
                HierarchicalItem.Folder(
                    id = "shimmer",
                    displayName = "Shimmer",
                    level = 1,
                    children = listOf(
                        HierarchicalItem.Item(
                            id = "shimmer-default",
                            displayName = "Shimmer Default",
                            value = shimmerDefault,
                            level = 2,
                        ),
                        HierarchicalItem.Item(
                            id = "shimmer-one-wave",
                            displayName = "Shimmer One Wave",
                            value = shimmerOneWave,
                            level = 2,
                        ),
                    )
                ),
                HierarchicalItem.Folder(
                    id = "loading",
                    displayName = "Loading",
                    level = 1,
                    children = listOf(
                        HierarchicalItem.Item(
                            id = "animated-loading-bars-default",
                            displayName = "Animated Loading Bars",
                            value = animatedLoadingBarsDefault,
                            level = 2,
                        ),
                    )
                ),
                HierarchicalItem.Folder(
                    id = "layouts",
                    displayName = "Layouts",
                    children = listOf(
                        HierarchicalItem.Item(
                            id = "adaptive-layout-default",
                            displayName = "Adaptive Layout",
                            value = adaptiveLayoutDefault
                        ),
                        HierarchicalItem.Item(
                            id = "adaptive-view-collection-default",
                            displayName = "Adaptive View Collection",
                            value = adaptiveViewCollectionDefault
                        ),
                    )
                )
            )
        )
    }

    val isDarkTheme by viewBookState.getIsDarkTheme()

    AppTheme(isDarkTheme = isDarkTheme) {
        ViewBook(
            viewBookState = viewBookState,
            isDarkTheme = isDarkTheme,
        )
    }
}
