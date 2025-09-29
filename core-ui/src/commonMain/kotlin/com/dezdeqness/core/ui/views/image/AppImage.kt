package com.dezdeqness.core.ui.views.image

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.ImageLoader
import coil3.compose.AsyncImage
import coil3.compose.AsyncImagePainter.State
import coil3.compose.LocalPlatformContext
import coil3.request.ImageRequest
import coil3.request.crossfade

@Composable
fun AppImage(
    modifier: Modifier = Modifier,
    data: Any,
    shape: Shape = RoundedCornerShape(8.dp),
    colorFilter: ColorFilter? = null,
    contentScale: ContentScale = ContentScale.Crop,
    contentDescription: String? = null,
    placeholder: Painter? = null,
    error: Painter? = null,
) {
    val context = LocalPlatformContext.current
    val loader = LocalAstImageLoader.current

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
        placeholder = placeholder,
        error = error,
        modifier = modifier.clip(shape),
    )
}

@Composable
fun AppImage(
    modifier: Modifier = Modifier,
    data: Any,
    onLoading: ((State.Loading) -> Unit)? = null,
    onSuccess: ((State.Success) -> Unit)? = null,
    onError: ((State.Error) -> Unit)? = null,
    contentScale: ContentScale = ContentScale.Crop,
    contentDescription: String? = null,
    placeholder: Painter? = null,
    error: Painter? = null,
) {
    val context = LocalPlatformContext.current
    val loader = LocalAstImageLoader.current

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
        placeholder = placeholder,
        error = error,
        imageLoader = loader,
        modifier = modifier
    )
}

@Composable
fun AppImage(
    modifier: Modifier = Modifier,
    request: ImageRequest,
    shape: Shape = RoundedCornerShape(8.dp),
    colorFilter: ColorFilter? = null,
    contentScale: ContentScale = ContentScale.Crop,
    contentDescription: String? = null,
    placeholder: Painter? = null,
    error: Painter? = null,
) {
    val loader = LocalAstImageLoader.current

    AsyncImage(
        model = request,
        contentScale = contentScale,
        contentDescription = contentDescription,
        colorFilter = colorFilter,
        imageLoader = loader,
        placeholder = placeholder,
        error = error,
        modifier = modifier.clip(shape),
    )
}

@Composable
fun AppImage(
    modifier: Modifier = Modifier,
    request: ImageRequest,
    onLoading: ((State.Loading) -> Unit)? = null,
    onSuccess: ((State.Success) -> Unit)? = null,
    onError: ((State.Error) -> Unit)? = null,
    contentScale: ContentScale = ContentScale.Crop,
    contentDescription: String? = null,
    placeholder: Painter? = null,
    error: Painter? = null,
) {
    val loader = LocalAstImageLoader.current

    AsyncImage(
        model = request,
        contentScale = contentScale,
        contentDescription = contentDescription,
        onLoading = onLoading,
        onSuccess = onSuccess,
        onError = onError,
        placeholder = placeholder,
        error = error,
        imageLoader = loader,
        modifier = modifier
    )
}

val LocalAstImageLoader = staticCompositionLocalOf<ImageLoader> {
    error("LocalAstImageLoader should be set")
}
