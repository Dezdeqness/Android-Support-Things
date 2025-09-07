package com.dezdeqness.core.ui.views.image

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.ImageLoader
import coil3.compose.AsyncImage
import coil3.compose.AsyncImagePainter.State
import coil3.compose.LocalPlatformContext
import coil3.request.ImageRequest
import coil3.request.crossfade
import coil3.util.DebugLogger

@Composable
fun AppImage(
    modifier: Modifier = Modifier,
    data: String,
    shape: Shape = RoundedCornerShape(8.dp),
    colorFilter: ColorFilter? = null,
    contentScale: ContentScale = ContentScale.Crop,
    contentDescription: String? = null,
    placeholderVector: ImageVector,
    errorVector: ImageVector,
) {
    val context = LocalPlatformContext.current
    val loader = remember {
        ImageLoader.Builder(context)
            .logger(DebugLogger())
            .build()
    }

    val model = remember(data) {
        ImageRequest.Builder(context)
            .data(data)
            .crossfade(true)
            .build()
    }

    AsyncImage(
        model = model,
        contentScale = contentScale,
        contentDescription = contentDescription,
        colorFilter = colorFilter,
        imageLoader = loader,
//        placeholder = rememberVectorPainter(image = placeholderVector),
//        error = rememberVectorPainter(image = errorVector),
        modifier = modifier.clip(shape),
    )

}

@Composable
fun AppImage(
    modifier: Modifier = Modifier,
    data: String,
    onLoading: ((State.Loading) -> Unit)? = null,
    onSuccess: ((State.Success) -> Unit)? = null,
    onError: ((State.Error) -> Unit)? = null,
    contentScale: ContentScale = ContentScale.Crop,
    contentDescription: String? = null,
    placeholderVector: ImageVector,
    errorVector: ImageVector,
) {
    val context = LocalPlatformContext.current
    val loader = remember {
        ImageLoader.Builder(context)
            .logger(DebugLogger())
            .build()
    }

    val model = remember(data) {
        ImageRequest.Builder(context)
            .data(data)
            .crossfade(true)
            .build()
    }

    AsyncImage(
        model = model,
        contentScale = contentScale,
        contentDescription = contentDescription,
        onLoading = onLoading,
        onSuccess = onSuccess,
        onError = onError,
        placeholder = rememberVectorPainter(image = placeholderVector),
        error = rememberVectorPainter(image = errorVector),
        imageLoader = loader,
        modifier = modifier
    )

}
