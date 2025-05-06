package nikmax.shimmer

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.InfiniteRepeatableSpec
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp

internal fun Modifier.colorPulsation(
    firstColor: Color,
    secondColor: Color,
    animationSpec: InfiniteRepeatableSpec<Color> = InfiniteRepeatableSpec<Color>(
        animation = tween(
            durationMillis = 1500,
            delayMillis = 500,
            easing = LinearEasing
        ),
        repeatMode = RepeatMode.Reverse
    )
): Modifier = composed {
    val backgroundColor =
        if (firstColor == DEFAULT_COLOR) MaterialTheme.colorScheme.surfaceContainer
        else firstColor
    val activeColor =
        if (secondColor == DEFAULT_COLOR) MaterialTheme.colorScheme.surfaceDim
        else secondColor
    var size by remember { mutableStateOf(IntSize.Zero) }
    val transition = rememberInfiniteTransition()
    val animatedColor by transition.animateColor(
        initialValue = backgroundColor,
        targetValue = activeColor,
        animationSpec = animationSpec
    )
    background(color = animatedColor).onGloballyPositioned {
        size = it.size
    }
}

@Preview
@Composable
private fun ColorPulsationPreview() {
    ShimmerPreviewLayout {
        Box(
            Modifier
                .size(100.dp)
                .shimmerBackground(
                    ShimmerEffect.ColorChangeShimmerEffect.ColorPulsation()
                )
        )
    }
}
