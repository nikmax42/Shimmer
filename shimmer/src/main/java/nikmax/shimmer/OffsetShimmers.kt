package nikmax.shimmer

import androidx.compose.animation.core.InfiniteRepeatableSpec
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp

internal fun Modifier.horizontalWave(
    backgroundColor: Color,
    waveColor: Color,
    animationSpec: InfiniteRepeatableSpec<Float> = InfiniteRepeatableSpec<Float>(
        tween(
            durationMillis = 1500,
            delayMillis = 1500,
            easing = LinearEasing
        )
    )
): Modifier = composed {
    val backgroundColor =
        if (backgroundColor == DEFAULT_COLOR) MaterialTheme.colorScheme.surfaceContainer
        else backgroundColor
    val waveColor =
        if (waveColor == DEFAULT_COLOR) MaterialTheme.colorScheme.surfaceDim
        else waveColor
    
    var size by remember { mutableStateOf(IntSize.Zero) }
    val transition = rememberInfiniteTransition()
    val startOffsetX by transition.animateFloat(
        initialValue = -2 * size.width.toFloat(),
        targetValue = 2 * size.width.toFloat(),
        animationSpec = animationSpec
    )
    background(
        brush = Brush.linearGradient(
            colors = listOf(
                backgroundColor,
                waveColor,
                backgroundColor,
            ),
            start = Offset(x = startOffsetX, y = 0f),
            end = Offset(x = startOffsetX + size.width.toFloat(), y = 0f)
        )
    ).onGloballyPositioned {
        size = it.size
    }
}

@Preview
@Composable
private fun HorizontalWavePreview() {
    ShimmerPreviewLayout {
        Box(
            Modifier
                .size(100.dp)
                .shimmerBackground(
                    ShimmerEffect.OffsetShimmerEffect.HorizontalWave()
                )
        )
    }
}
