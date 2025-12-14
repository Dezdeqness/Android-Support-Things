package com.dezdeqness.ast

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.dezdeqness.ast.viewbook.core.ViewBook
import com.dezdeqness.ast.viewbook.core.ViewBookState
import com.dezdeqness.ast.viewbook.core.ui.HierarchicalItem
import com.dezdeqness.ast.views.appSectionDefault
import com.dezdeqness.ast.views.buttonDefault
import com.dezdeqness.ast.views.buttonOutlined
import com.dezdeqness.ast.views.buttonText
import com.dezdeqness.ast.views.chipDefault
import com.dezdeqness.ast.views.emptyStateDefault
import com.dezdeqness.ast.views.errorStateDefault
import com.dezdeqness.ast.views.headerDefault
import com.dezdeqness.ast.views.headerIconLess
import com.dezdeqness.ast.views.headerSettingsColor
import com.dezdeqness.ast.views.headerSettingsDefault
import com.dezdeqness.ast.views.headerShaped
import com.dezdeqness.ast.views.iconButtonDefault
import com.dezdeqness.ast.views.iconFilledButtonDefault
import com.dezdeqness.ast.views.iconOutlinedButtonDefault
import com.dezdeqness.ast.views.progressSettingsDefault
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
                        )
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
                        )
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
