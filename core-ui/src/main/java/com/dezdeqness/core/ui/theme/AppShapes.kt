package com.dezdeqness.core.ui.theme

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.dp
import com.dezdeqness.core.ui.theme.base.BaseShapes

@Immutable
data class AppShapes(
    override val small: CornerBasedShape = RoundedCornerShape(4.dp),
    override val medium: CornerBasedShape = RoundedCornerShape(8.dp),
    override val large: CornerBasedShape = RoundedCornerShape(12.dp),
) : BaseShapes
